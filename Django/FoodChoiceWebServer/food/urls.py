from django.urls import path
from . import views

app_name = 'food'
urlpatterns = [
        path('',views.FoodList.as_view(), name='foods')
        ]
