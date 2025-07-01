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

# insert
def create_product():
    data = request.json     # 클라이언트에서 전송한 JSON 데이터
    result = products.insert_one(data)  # MongoDB에 삽입
    return jsonify({"id": str(result.inserted_id)}), 201

# 전체 상품 조회
def get_all_products():
    return jsonify([convert_doc(doc) for doc in products.find()])

# 개별 상품 조회
def get_product_by_name(name):
    doc = products.find_one({"name": name})
    return jsonify(convert_doc(doc)) if doc else (jsonify({"error": "Not found"}), 404)

# 상품 갱신
def update_product(name):
    data = request.json
    result = products.update_one({"name": name}, {"$set": data})
    return jsonify({"modified": result.modified_count})

# 상품 삭제
def delete_product(name):
    result = products.delete_one({"name": name})
    return jsonify({"deleted": result.deleted_count})
