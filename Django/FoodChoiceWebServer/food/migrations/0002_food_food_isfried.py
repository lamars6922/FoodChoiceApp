# Generated by Django 2.2.5 on 2019-10-09 13:49

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('food', '0001_initial'),
    ]

    operations = [
        migrations.AddField(
            model_name='food',
            name='food_isfried',
            field=models.CharField(default=2, max_length=30),
            preserve_default=False,
        ),
    ]
