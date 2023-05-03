package utils

/*
this enum class stores all colors for fields and pieces
 */
enum class Colors(val color: String) {
    CYAN_BG("\u001B[46m"),
    GREY_BG("\u001B[47m"),
    CYAN_PI("\u001B[36m"),
    WHITE_PI("\u001B[47m"),
    BLACK_PI("\u001B[30m"),
    RESET_COLOR("\u001B[0m")
}