package com.kinchin.test;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VidaCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender target, Command command, String label, String[] args) {

        if (target instanceof Player player) {

            if (args.length == 0) {
                player.sendMessage("§aUse: /vida <quantidade>");
                return true;
            }

            double vidaDigitada;
        try {
            vidaDigitada = Double.parseDouble(args[0]);
        } catch (NumberFormatException e) {
            player.sendMessage("§4§lERRO §cVocê precisa digitar um número de 1 a 10.");
            return true;
        }

            if (vidaDigitada < 1 || vidaDigitada > 10) {
                player.sendMessage("§cO valor minimo é 1 e o máximo é 10");
                return true;
            }

            double vidaFinal = vidaDigitada * 2;

            if (player.getHealth() == vidaFinal) {
                player.sendMessage(ChatColor.YELLOW + "Você já está com essa quantidade de vida!");
                return true;
            }

            player.setHealth(vidaFinal);
            player.sendMessage(ChatColor.GREEN + "Você mudou sua vida para " + (int)vidaDigitada);

        }

        return true;
    }
}