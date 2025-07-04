from flask import jsonify, request

def analyze_post():
    data = request.get_json()
    print(f"✅ 분석 요청 수신: {data}")  # 터미널 로그로 확인
    return jsonify({"message": "분석 요청 수신 완료", "received": True})