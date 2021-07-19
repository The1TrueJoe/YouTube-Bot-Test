# Web frontend for the YouTube bot
# Written by Joseph Telaak


# Import
from unused import WebRequest
import YouTubeBot as Bot
import time


# Prints header
def header():
    print("*************************************************")
    print()


# Main
def main():
    # Introduction
    header()
    print("Welcome to the YouTube view bot")
    print("Written by Joseph Telaak")
    header()

    # Client Mode
    print()
    print("NOTE: This version running in Web-Client Mode")
    print("To run as independent, run IndpMain.py")
    print()

    # Wait
    time.sleep(1)

    # Get Web Request
    ip = ""
    url = WebRequest.getWebsite(ip)

    # Wait
    time.sleep(1)

    # Print
    print("URL From Web Server: " + url)

    # Run bot
    Bot.run(url)
