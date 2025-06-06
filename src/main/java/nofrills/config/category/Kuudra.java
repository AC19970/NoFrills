package nofrills.config.category;

import dev.isxander.yacl3.api.ConfigCategory;
import dev.isxander.yacl3.api.Option;
import dev.isxander.yacl3.api.OptionDescription;
import dev.isxander.yacl3.api.controller.ColorControllerBuilder;
import dev.isxander.yacl3.api.controller.StringControllerBuilder;
import net.minecraft.text.Text;
import nofrills.config.Config;

import java.awt.*;

public class Kuudra {
    public static ConfigCategory create(Config defaults, Config config) {
        return ConfigCategory.createBuilder()
                .name(Text.of("Kuudra"))

                .option(Option.<Boolean>createBuilder()
                        .name(Text.of("Render Hitbox"))
                        .description(OptionDescription.of(Text.of("Renders a hitbox for the big man himself.")))
                        .binding(false, () -> Config.kuudraHitbox, value -> Config.kuudraHitbox = value)
                        .controller(Config::booleanController)
                        .build())

                .option(Option.<Color>createBuilder()
                        .name(Text.of("Kuudra Color"))
                        .description(OptionDescription.of(Text.of("The color of Kuudra's hitbox.")))
                        .binding(new Color(255, 255, 0, 255),
                                () -> Config.kuudraColor,
                                value -> Config.kuudraColor = value)
                        .controller(v -> ColorControllerBuilder.create(v).allowAlpha(true))
                        .build())

                .option(Option.<Boolean>createBuilder()
                        .name(Text.of("Render Health"))
                        .description(OptionDescription.of(Text.of("Renders Kuudra's exact health during the third (DPS) phase.")))
                        .binding(false, () -> Config.kuudraHealth, value -> Config.kuudraHealth = value)
                        .controller(Config::booleanController)
                        .build())

                .option(Option.<Boolean>createBuilder()
                        .name(Text.of("Render DPS"))
                        .description(OptionDescription.of(Text.of("Calculates your team's DPS on Kuudra during the last phase, and renders it on screen. Only applies in Infernal tier.")))
                        .binding(false, () -> Config.kuudraDPS, value -> Config.kuudraDPS = value)
                        .controller(Config::booleanController)
                        .build())

                .option(Option.<Boolean>createBuilder()
                        .name(Text.of("Announce Missing"))
                        .description(OptionDescription.of(Text.of("Announces in party chat if no supply spawns at either your current pre spot, or at your next spot.")))
                        .binding(false, () -> Config.kuudraMissing, value -> Config.kuudraMissing = value)
                        .controller(Config::booleanController)
                        .build())

                .option(Option.<Boolean>createBuilder()
                        .name(Text.of("Announce Fresh"))
                        .description(OptionDescription.of(Text.of("Sends a message when the Fresh Tools perk activates.")))
                        .binding(false, () -> Config.kuudraFresh, value -> Config.kuudraFresh = value)
                        .controller(Config::booleanController)
                        .build())

                .option(Option.<String>createBuilder()
                        .name(Text.of("Fresh Message"))
                        .description(OptionDescription.of(Text.of("The message to send when Fresh Tools activates.")))
                        .binding("/pc EAT FRESH!", () -> Config.kuudraFreshMsg, value -> Config.kuudraFreshMsg = value)
                        .controller(StringControllerBuilder::create)
                        .build())

                .option(Option.<Boolean>createBuilder()
                        .name(Text.of("Fresh Timer"))
                        .description(OptionDescription.of(Text.of("Render a timer on screen when Fresh Tools activates.")))
                        .binding(false, () -> Config.kuudraFreshTimer, value -> Config.kuudraFreshTimer = value)
                        .controller(Config::booleanController)
                        .build())

                .option(Option.<Boolean>createBuilder()
                        .name(Text.of("Announce Drain"))
                        .description(OptionDescription.of(Text.of("Sends a message when you drain your mana using an End Stone Sword. Also hides the messages related to the ability.")))
                        .binding(false, () -> Config.kuudraDrain, value -> Config.kuudraDrain = value)
                        .controller(Config::booleanController)
                        .build())

                .option(Option.<String>createBuilder()
                        .name(Text.of("Drain Message"))
                        .description(OptionDescription.of(Text.of("The message to send when you drain your mana. Replaces {mana} with how much mana was used, and {players} with the amount of affected players.")))
                        .binding("/pc Used {mana} Mana on {players} players!", () -> Config.kuudraDrainMsg, value -> Config.kuudraDrainMsg = value)
                        .controller(StringControllerBuilder::create)
                        .build())

                .option(Option.<Boolean>createBuilder()
                        .name(Text.of("Stun Waypoint"))
                        .description(OptionDescription.of(Text.of("Render a waypoint for the easiest to break pod while you are stunning Kuudra.")))
                        .binding(false, () -> Config.kuudraStunWaypoint, value -> Config.kuudraStunWaypoint = value)
                        .controller(Config::booleanController)
                        .build())

                .option(Option.<Color>createBuilder()
                        .name(Text.of("Stun Waypoint Color"))
                        .description(OptionDescription.of(Text.of("The color used for the stun waypoint.")))
                        .binding(new Color(0, 255, 255, 170),
                                () -> Config.kuudraStunColor,
                                value -> Config.kuudraStunColor = value)
                        .controller(v -> ColorControllerBuilder.create(v).allowAlpha(true))
                        .build())

                .option(Option.<Boolean>createBuilder()
                        .name(Text.of("Supply Beacons"))
                        .description(OptionDescription.of(Text.of("Renders beacon beams for every nearby supply in Kuudra.")))
                        .binding(false, () -> Config.kuudraSupplyHighlight, value -> Config.kuudraSupplyHighlight = value)
                        .controller(Config::booleanController)
                        .build())

                .option(Option.<Color>createBuilder()
                        .name(Text.of("Supply Beacon Color"))
                        .description(OptionDescription.of(Text.of("The color used for the supply beacons.")))
                        .binding(new Color(0, 255, 255, 127),
                                () -> Config.kuudraSupplyColor,
                                value -> Config.kuudraSupplyColor = value)
                        .controller(v -> ColorControllerBuilder.create(v).allowAlpha(true))
                        .build())

                .option(Option.<Boolean>createBuilder()
                        .name(Text.of("Drop Off Beacons"))
                        .description(OptionDescription.of(Text.of("Renders beacon beams for every available supply drop-off point.")))
                        .binding(false, () -> Config.kuudraDropHighlight, value -> Config.kuudraDropHighlight = value)
                        .controller(Config::booleanController)
                        .build())

                .option(Option.<Color>createBuilder()
                        .name(Text.of("Drop Off Beacon Color"))
                        .description(OptionDescription.of(Text.of("The color used for the drop-off point beacons.")))
                        .binding(new Color(255, 255, 0, 127),
                                () -> Config.kuudraDropColor,
                                value -> Config.kuudraDropColor = value)
                        .controller(v -> ColorControllerBuilder.create(v).allowAlpha(true))
                        .build())

                .option(Option.<Boolean>createBuilder()
                        .name(Text.of("Build Beacons"))
                        .description(OptionDescription.of(Text.of("Renders beacon beams for every supply pile that is not built yet.")))
                        .binding(false, () -> Config.kuudraBuildHighlight, value -> Config.kuudraBuildHighlight = value)
                        .controller(Config::booleanController)
                        .build())

                .option(Option.<Color>createBuilder()
                        .name(Text.of("Build Beacon Color"))
                        .description(OptionDescription.of(Text.of("The color used for the build pile beacons.")))
                        .binding(new Color(0, 255, 0, 127),
                                () -> Config.kuudraBuildColor,
                                value -> Config.kuudraBuildColor = value)
                        .controller(v -> ColorControllerBuilder.create(v).allowAlpha(true))
                        .build())

                .build();
    }
}