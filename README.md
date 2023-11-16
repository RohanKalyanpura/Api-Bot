# Java IRC Api- Bot

This Java IRC bot is a simple and extensible project written using the PircBot library. It establishes a connection to an IRC server and channel, providing various features and commands for interaction.

## Features

- **Connection Handling:**
  - Connects to an IRC server and channel specified in the `.env` file.
  - Uses the PircBot library for seamless IRC communication.

- **Basic Commands:**
  - Responds to `time` with the current time.
  - Responds to `menu` by listing available bot commands.
  - Responds to `kanyequotes` with a randomly selected Kanye West quote.

- **Weather Information:**
  - Responds to `weather` by prompting the user for a location.
  - Utilizes the OpenWeatherMap API to fetch and display the current weather for the specified location.
  - Requires an OpenWeatherMap API key, which should be added to the `.env` file.

## Usage

Follow these steps to set up and run the Java IRC bot:

1. **Clone the Repository:**
   ```bash
   git clone 
