from flask import request, jsonify
from pymongo import MongoClient
from bson import ObjectId

client = MongoClient("mongodb://localhost:27017/")
db = client["shopdb"]
products = db["products"]

def convert_doc(doc):
    doc["id"] = str(doc["_id"]) # MongoDB의 ObjectId를 문자열로 변환
    del doc["_id"]              # 원래 _id 필드는 삭제
    return doc

# 루트 경로
def root_path():
    return "Python Flask Root"

# POST: 상품 등록
def create_product():
    data = request.json
    result = products.insert_one(data)
    return jsonify({"id": str(result.inserted_id)}), 201

# GET: 전체 상품 조회
def get_all_products():
    return jsonify([convert_doc(doc) for doc in products.find()])

# GET: 특정 이름의 상품 조회
def get_product_by_name(name):
    doc = products.find_one({"name": name})
    return jsonify(convert_doc(doc)) if doc else (jsonify({"error": "Not found"}), 404)

# PUT: 특정 상품 수정
def update_product(name):
    data = request.json
    result = products.update_one({"name": name}, {"$set": data})
    return jsonify({"modified": result.modified_count})

# DELETE: 특정 상품 삭제
def delete_product(name):
    result = products.delete_one({"name": name})
    return jsonify({"deleted": result.deleted_count})

# ✅ GET: Aggregation 결과 반환 (재고 수량이 10개 이상인 상품 총합)
def get_total_quantity():
    pipeline = [
        { "$match": { "quantity": { "$gte": 10 } } },
        { "$group": { "_id": None, "totalQuantity": { "$sum": "$quantity" } } },
        { "$project": { "_id": 0, "totalQuantity": 1 } }
    ]
    result = list(products.aggregate(pipeline))
    return jsonify(result[0] if result else {"totalQuantity": 0})