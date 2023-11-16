# Java IRC Api- Bot

This Java IRC bot is a simple and extensible project written using the PircBot library. It establishes a connection to an IRC server and channel, providing various features and commands for interaction.

## Features

- **Connection Handling:**
  - Connects to an IRC server and channel specified in the `.env` file.
  - Uses the PircBot library for seamless IRC communication.

- **Basic Commands:**
  - Responds to `time` with the current time.
  - Responds to `menu` by listing available bot commands.
  - Responds to `Kanye Quotes` with a randomly selected Kanye West quote.

- **Weather Information:**
  - Responds to `weather` by prompting the user for a location.
  - Utilizes the OpenWeatherMap API to fetch and display the current weather for the specified location.
  - Requires an OpenWeatherMap API key, which should be added to the `.env` file.

## Usage

Follow these steps to set up and run the Java IRC bot:

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/RohanKalyanpura/Api-Bot.git
   ```
2. **Edit the env.txt file and make it just .env while replacing these values with your own**
    ``` java
    WEATHER_API_KEY = //put your openweathermap api key here
    Channel = //put your channel id here
    ```
3. **Compile Java Files**
     ```bash
        javac *.java
     ```
4.  **Run The Bot**
    ```bash
      java MyBotMain
    ```

