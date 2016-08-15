import datetime

from django.shortcuts import render_to_response

# Create your views here.
from django.http import HttpResponse, Http404


def hello(request, name):
    return HttpResponse("Hello world {0}".format(name))

def current_datetime(request, urlname):
    now = datetime.datetime.now()
    return render_to_response(urlname, {'current_date': now})

def hours_ahead(request, offset = '0'):
    try:
        hour_offset = int(offset)
    except ValueError:
        raise Http404()
    next_time = datetime.datetime.now() + datetime.timedelta(hours=hour_offset)
    return render_to_response('hours_ahead.html', locals())