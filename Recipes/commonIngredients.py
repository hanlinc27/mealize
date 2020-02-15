import pandas as pd

names = ['id', 'cuisine', 'ingredients']
dataset = pd.read_json('Recipes\\train.json', names=names, usecols=)
print(dataset.head(10))
