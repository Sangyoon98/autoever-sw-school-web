from pymongo import mongo_client, MongoClient

client = MongoClient("mongodb://localhost:27017/")
db = client["movie_db"]
collection = db["boxoffice"]