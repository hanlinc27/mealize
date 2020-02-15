# import pandas as pd

# cols = ['id', 'cuisine', 'ingredients']
# dataset = pd.read_json('Recipes\\train.json')
# dataset.to_csv("Recipes\\ingredients.csv")

import collections
import re
import csv

# words = re.findall(r'\w+', open('Recipes\\raw_ingredients.csv').read())
words = open('Recipes\\raw_ingredients.csv').read()
split_ = words.split()
most_common = collections.Counter(split_).most_common(250)
print(most_common)
print(most_common[0][0])

with open('Recipes\\commonIngredients.csv', mode='w') as commonIngredients:
    writ = csv.writer(commonIngredients)
    for i in range(len(most_common)):    
        writ.writerow(most_common[i][0])
