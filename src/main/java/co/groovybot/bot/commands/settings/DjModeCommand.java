package co.groovybot.bot.commands.settings;

import co.groovybot.bot.core.command.Command;
import co.groovybot.bot.core.command.CommandCategory;
import co.groovybot.bot.core.command.CommandEvent;
import co.groovybot.bot.core.command.Result;
import co.groovybot.bot.core.command.permission.Permissions;
import co.groovybot.bot.core.entity.EntityProvider;
import co.groovybot.bot.core.entity.Guild;

public class DjModeCommand extends Command {

    public DjModeCommand() {
        super(new String[]{"setdj", "dj"}, CommandCategory.SETTINGS, Permissions.adminOnly(), "Lets you toggle the dj-mode", "");
    }

    @Override
    public Result run(String[] args, CommandEvent event) {
        Guild guild = EntityProvider.getGuild(event.getGuild().getIdLong());
        if (!guild.isDjMode()) {
            guild.setDjMode(true);
            return send(success(event.translate("command.dj.enabled.title"), event.translate("command.dj.enabled.description")));
        }
        guild.setDjMode(false);
        return send(success(event.translate("command.dj.disabled.title"), event.translate("command.dj.disabled.description")));
    }
}