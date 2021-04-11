package me.xingyan.linkrole;

import github.scarsz.discordsrv.api.Subscribe;
import github.scarsz.discordsrv.api.events.AccountLinkedEvent;
import github.scarsz.discordsrv.api.events.AccountUnlinkedEvent;
import github.scarsz.discordsrv.dependencies.jda.api.entities.Member;
import github.scarsz.discordsrv.dependencies.jda.api.entities.Role;
import github.scarsz.discordsrv.util.DiscordUtil;

import static me.xingyan.linkrole.Main.plugin;

public class discordsrvListener {




    @Subscribe
    public void accountsLinked(AccountLinkedEvent event) {
        // Example of broadcasting a message when a new account link has been made

        String roleID = plugin.getConfig().getString("roldID");

        Role role = DiscordUtil.getRole(roleID);
        Member user = DiscordUtil.getMemberById(event.getUser().getId());
        DiscordUtil.addRoleToMember(user, role);

    }

    @Subscribe
    public void accountUnlinked(AccountUnlinkedEvent event) {
        // Example of DM:ing user on unlink

        String roleID = plugin.getConfig().getString("roldID");

        Member user = DiscordUtil.getMemberById(event.getDiscordId());
        Role role = DiscordUtil.getRole(roleID);
        DiscordUtil.removeRolesFromMember(user, role);
    }

}