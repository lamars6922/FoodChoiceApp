from django.db import models

# Create your models here.
class Food(models.Model):
    food_name = models.CharField(max_length=30)
    food_type = models.CharField(max_length=30)
    food_isspicy = models.CharField(max_length=30)
    food_isprice = models.CharField(max_length=30)
    food_issoup = models.CharField(max_length=30)
    food_isfast = models.CharField(max_length=30)
    food_ismeat = models.CharField(max_length=30)
    food_isrice = models.CharField(max_length=30)
    food_ishot = models.CharField(max_length=30)
    food_isheavy = models.CharField(max_length=30)
    food_isfried = models.CharField(max_length=30)
