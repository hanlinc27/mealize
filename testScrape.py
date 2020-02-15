import requests

BASE_URL = 'https://flipp.com'
BACKEND_URL = 'https://backflipp.wishabi.com/flipp'
SEARCH_URL = '%s/items/search' % BACKEND_URL
ITEM_URL = '%s/items/' % BACKEND_URL

def scrape_item(item_id):
    return requests.get(
        "%s/%s" % (ITEM_URL, item_id,)
    ).json()

def search(query, postal_code):
    data = requests.get(
        SEARCH_URL,
        params = {
            'q': query,
            'postal_code': postal_code,
        }
    ).json()

    return [
            scrape_item(x.get('flyer_item_id'))
            for x in data.get('items')
    ]

items = search('FoodBasics', 'M2H2E8')
for i in range(1):
    print(items[i])
