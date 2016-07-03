from django.conf.urls import url

from . import views

urlpatterns = [
    url(r'^$', views.hello, name='hello'),
    url(r'^time$', views.current_datetime, name='current_datetime'),
    url(r'^time/plus/(\d{1,2})/$', views.hours_ahead, name='hours_ahead'),
]