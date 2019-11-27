from rest_framework import serializers
from .models import Food

class FoodSerializer(serializers.ModelSerializer):
    class Meta:
        model = Food
        fields = ('id', 'food_name','food_type','food_isspicy','food_isprice','food_issoup','food_isfast','food_ismeat','food_isrice','food_ishot','food_isheavy','food_isfried')

