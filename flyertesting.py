# import requests

# BASE_URL = 'https://flipp.com'
# BACKEND_URL = 'https://flipp.com/search/Food%20Basics'
# SEARCH_URL = '%s/items/search' % BACKEND_URL
# ITEM_URL = '%s/items/' % BACKEND_URL

# def scrape_item(item_id):
#     return requests.get(
#         "%s/%s" % (ITEM_URL, item_id,)
#     ).json()

# def search(food, M2M2X7):
#     data = requests.get(
#         SEARCH_URL,
#         params = {
#             'q': query,
#             'postal_code': postal_code,
#         }
#     ).json()

#     return [
#             scrape_item(x.get('flyer_item_id'))
#             for x in data.get('items')
#     ]



# import requests
# from bs4 import BeautifulSoup

# url = "https://flipp.com/search/Food%20Basics"
# page = requests.get(url)
# #print(requests.status())
# soup = BeautifulSoup(page.content, 'html.parser')
# # results = soup.find(id='ResultsContainer')
# # print(results.prettify())
# print(soup)


import requests
import lxml.html


