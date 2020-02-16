import pandas as pd

dataset = pd.read_json('Recipes\\recipes_raw.json')
dataset.to_csv("Recipes\\recipes.csv")
