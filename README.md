# DiscordHook

Discord Hook is a simple minecraft plugin that sends join and leave messages to a discord channel using a webhook.

## Setup

Discord Hook is a **paper** plugin.

When started for the first time, the plugin will generate a configuration file with one key named `webhook`. 
This is where you must put your webhook link. 

If this link is not provided, the plugin will send a warning each time someone logs in or out of the minecraft server.

## Creating a webhook

On discord, go in **Server settings** > **Integrations** > **Webhooks** and click on **New webhook**. You can then copy the webhook URL and paste it in the configuration file.
