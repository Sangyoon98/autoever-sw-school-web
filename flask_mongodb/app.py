from flask import Flask
from flask_cors import CORS
from apscheduler.schedulers.background import BackgroundScheduler
from scheduler.job import fetch_and_store
from routes.boxoffice import get_box_office
from routes.product import (root_path,
                            create_product,
                            get_all_products,
                            get_product_by_name,
                            update_product,
                            delete_product,
                            get_total_quantity
                            )

app = Flask(__name__)
CORS(app, origins="http://localhost:5173")

# 라우터 등록
app.add_url_rule("/", view_func=root_path, methods=["GET"])
app.add_url_rule("/products", view_func=create_product, methods=["POST"])
app.add_url_rule("/products", view_func=get_all_products, methods=["GET"])
app.add_url_rule("/products/<name>", view_func=get_product_by_name, methods=["GET"])
app.add_url_rule("/products/<name>", view_func=update_product, methods=["PUT"])
app.add_url_rule("/products/<name>", view_func=delete_product, methods=["DELETE"])
app.add_url_rule("/api/boxoffice", view_func=get_box_office, methods=["GET"])
app.add_url_rule("/products/summary", view_func=get_total_quantity, methods=["GET"])

# 스케쥴러 등록
scheduler = BackgroundScheduler()
scheduler.add_job(fetch_and_store, 'cron', hour=12, minute=40)
scheduler.start()

if __name__ == "__main__":
    app.run(debug=True)