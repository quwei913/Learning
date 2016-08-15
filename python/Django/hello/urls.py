from django.conf.urls import url

from . import views
urlpatterns = [
    url(r'^time$', views.current_datetime, {'urlname' : 'current_datetime.html'}, name='current_datetime'),
    url(r'^time/one_day/$', views.hours_ahead, {'offset' : '24'}, name='hours_ahead'),
    url(r'^time/plus(?P<offset>\d{1,2})/$', views.hours_ahead, name='hours_ahead'),
    url(r'^$', views.hello, name='hello'),
]
