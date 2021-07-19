# This is a YouTube view bot designed to be deployed in a server config

# Written by Joseph Telaak



# Import

import time

import pyautogui as gui

import subprocess as cmd

import urllib.request

import json
import ssl




# Refreshes website

def refresh():
    
	# Print
    
	print("Refresh")

    

	# GUI Press f5 refresh key
    
	gui.press('f5')





# Runs website refresh given website
def run(website):
    
	
	# Start
    
	print()
    
	print("Starting YouTube Bot....")

    
	
	# Wait
    
	time.sleep(1)

    

	# Starts chrome.exe with website given
    
	print("Running chrome.exe")
    
	process = cmd.Popen("start chrome.exe " + website)
    
	process.communicate()

    

	# Waits for video to load
    
	print("Waiting for load.....")
    
	time.sleep(15)
    
	print("Loaded")

    

	# Constantly refreshes website
    
	print("Starting process")
    
	while True:
        
		refresh()
        
		time.sleep(5)





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
    
	quote = parsed_json['quote']    

	# Use Example: quote['type']

    
	return quote['URL']





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
    
	url = getWebsite(ip)

    
	
	# Wait
    
	time.sleep(1)

   

 	# Print
    
	print("URL From Web Server: " + url)

    

	# Run bot
    
	run(url)
