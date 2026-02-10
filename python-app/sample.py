import os
from flask import Flask, request

app = Flask(__name__)

APP_NAME = os.getenv("APP_NAME", "DefaultApp")
ENVIRONMENT = os.getenv("ENVIRONMENT", "dev")

@app.before_request
def log_request():
    print(f"Request: {request.method} {request.path} from {request.remote_addr}")

@app.route("/")
def hello():
    print(f"HELLO WORLD!!!!! {APP_NAME} AND {ENVIRONMENT}")
    return f"Hello from {APP_NAME} running in {ENVIRONMENT}"

app.run(host="0.0.0.0", port=3000)
