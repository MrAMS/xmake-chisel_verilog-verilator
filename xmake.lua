add_rules("plugin.compile_commands.autoupdate")

add_requires("verilator")
add_requires("fmt")

option("WAVE_MAX_CYCLES")
    set_default("10")
    set_showmenu(true)
    set_category("wave")
    set_description("Wave Max Cycles")
    after_check(function (option)
        option:set("configvar", option:name(), option:value(), {quote = false})
    end)

includes("verilog", "chisel")
