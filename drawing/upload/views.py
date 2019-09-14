from django.shortcuts import render
# Create your views here.
from upload.models import Img


def upload(request):  # 图片上传函数
    if request.method == 'POST':
        img = Img(img_url=request.FILES.get('file'))
        img.save()
    return render(request, 'upload.html')