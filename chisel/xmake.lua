target("chisel")
    set_kind("phony")
    on_build(function (target)
        os.cd("chisel")
        os.exec("mill demo.run")
    end)

target("chisel_demo")
    add_rules("verilator.binary")
    set_toolchains("@verilator")
    add_files("csrc/*.cpp")
    add_files("build/*.sv")
    add_values("verilator.flags", "--trace", "--timing")

    add_options("WAVE_FILE_NAME", "WAVE_MAX_CYCLES", "CNTER_WIDTH")
    add_includedirs("$(buildir)")
    
    add_configfiles("csrc/config_chisel.h.in")
    after_run(function (target)
        os.exec("gtkwave %s/wave.vcd", target:targetdir())
    end)

    add_packages("fmt")