package net.itsred_v2.discordhook.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import club.minnced.discord.webhook.WebhookClient;
import club.minnced.discord.webhook.send.WebhookEmbed;
import club.minnced.discord.webhook.send.WebhookEmbedBuilder;
import net.itsred_v2.discordhook.Main;

public class OnQuitListener implements Listener {

    private final Main plugin;

    public OnQuitListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        String webhookURL = plugin.getConfig().getString("webhook");
        if (webhookURL == null) {
            Bukkit.getLogger().warning("[DiscordHook] Please define a webhook url in the config file.");
            return;
        }

        Player player = event.getPlayer();
        String playerName = player.getName();
        String iconUrl = "https://mc-heads.net/avatar/" + player.getUniqueId();

        WebhookEmbed quitEmbed = new WebhookEmbedBuilder()
                .setColor(0xd70000)
                .setAuthor(new WebhookEmbed.EmbedAuthor(playerName, iconUrl, null))
                .setDescription(playerName + " left the game")
                .build();

        WebhookClient client = WebhookClient.withUrl(webhookURL);
        client.send(quitEmbed);
        client.close();
    }

}
