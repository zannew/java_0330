from flask import Flask

# 웹서버 생성
app = Flask(__name__)

# URL설정
@app.route("/")
def index():
    return "Hello world!"