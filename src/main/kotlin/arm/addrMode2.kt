package ic.org.arm

sealed class AddrMode2 : Printable

/* Normal Offset */

data class ImmOffsetAddrMode2(val rn: Reg, val imm: Immed_12) : AddrMode2() {
  override val code = "[${rn.code}, #+${imm.code}]"
}
data class ZeroOffsetAddrMode2(val rn: Reg) : AddrMode2() {
  override val code = "[${rn.code}]"
}
data class RegOffsetAddrMode2(val rn: Reg, val sign: Sign, val rm: Reg) : AddrMode2() {
  override val code = "[${rn.code}, ${sign.code}${rm.code}]"
}

/* Pre-indexed Offset */

data class ImmPreOffsetAddrMode2(val rn: Reg, val imm: Immed_12) : AddrMode2() {
  override val code = "[${rn.code}], #+${imm.code}"
}
data class ZeroPreOffsetAddrMode2(val rn: Reg) : AddrMode2() {
  override val code = "[${rn.code}]"
}
data class RegPreOffsetAddrMode2(val rn: Reg, val sign: Sign, val rm: Reg) : AddrMode2() {
  override val code = "[${rn.code}, ${sign.code}${rm.code}]!"
}

/* Post-indexed Offset */

data class ImmPostOffsetAddrMode2(val rn: Reg, val sign: Sign, val imm: Immed_12) : AddrMode2() {
  override val code = "[${rn.code}], #${sign.code}${imm.code}"
}
data class ZeroPostOffsetAddrMode2(val rn: Reg) : AddrMode2() {
  override val code = "[${rn.code}]"
}
data class RegPostOffsetAddrMode2(val rn: Reg, val sign: Sign, val rm: Reg) : AddrMode2() {
  override val code = "[${rn.code}], ${sign.code}${rm.code}"
}