# Pulls data from a predefined web server to use for YouTube-Bot
# Written by Joseph Telaak


# Import
import urllib.request
import json
import ssl


# Gets website data
def getWebsite(ip):

    # CTX
    ctx = ssl.create_default_context()
    ctx.check_hostname = False
    ctx.verify_mode = ssl.CERT_NONE

    # URL
    url = "http://" + ip + "/YouTubeURL.json"

    # Fetch data
    with urllib.request.urlopen(url, context=ctx) as response:
        data = response.read()
        parsed_json = json.loads(data)

    # Quote
    quote = parsed_json['quote']    # Use Example: quote['type']

    return quote['URL']
