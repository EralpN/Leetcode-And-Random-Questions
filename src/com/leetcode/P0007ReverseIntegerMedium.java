package com.leetcode;

public class P0007ReverseIntegerMedium {
	// 2,147,483,647 max 32 bit int
	// -2,147,483,648 min 32 bit int

	public static void main(String[] args) {
		P0007ReverseIntegerMedium q = new P0007ReverseIntegerMedium();
		System.out.println(q.reverse(2147483647));
		System.out.println(q.reverse(-2147483648));
		System.out.println(q.reverse(2147483641));
		System.out.println(q.reverse(-2147483642));
		System.out.println(q.reverse(123));
		System.out.println(q.reverse(1200));

	}

	public int reverse(int x) {
		char[] chars = String.valueOf(x).toCharArray();
		if (chars[0] == '-' && chars.length == 11) {
			if (chars[10] == '2') {
				if (chars[9] == '1') {
					if (chars[8] == '4') {
						if (chars[7] == '7') {
							if (chars[6] == '4') {
								if (chars[5] == '8') {
									if (chars[4] == '3') {
										if (chars[3] == '6') {
											if (chars[2] == '4') {
												if (chars[1] <= '8') {
													return reverseAny(x);
												}
											} else if (chars[2] < '4') {
												return reverseAny(x);
											}
										} else if (chars[3] < '6') {
											return reverseAny(x);
										}
									} else if (chars[4] < '3') {
										return reverseAny(x);
									}
								} else if (chars[5] < '8') {
									return reverseAny(x);
								}
							} else if (chars[6] < '4') {
								return reverseAny(x);
							}
						} else if (chars[7] < '7') {
							return reverseAny(x);
						}
					} else if (chars[8] < '4') {
						return reverseAny(x);
					}
				} else if (chars[9] < '1') {
					return reverseAny(x);
				}
			} else if (chars[10] < '2') {
				return reverseAny(x);
			}
			return 0;
		} else if (chars[0] != '-' && chars.length == 10) {
			if (chars[9] == '2') {
				if (chars[8] == '1') {
					if (chars[7] == '4') {
						if (chars[6] == '7') {
							if (chars[5] == '4') {
								if (chars[4] == '8') {
									if (chars[3] == '3') {
										if (chars[2] == '6') {
											if (chars[1] == '4') {
												if (chars[0] <= '7') {
													return reverseAny(x);
												}
											} else if (chars[1] < '4') {
												return reverseAny(x);
											}
										} else if (chars[2] < '6') {
											return reverseAny(x);
										}
									} else if (chars[3] < '3') {
										return reverseAny(x);
									}
								} else if (chars[4] < '8') {
									return reverseAny(x);
								}
							} else if (chars[5] < '4') {
								return reverseAny(x);
							}
						} else if (chars[6] < '7') {
							return reverseAny(x);
						}
					} else if (chars[7] < '4') {
						return reverseAny(x);
					}
				} else if (chars[8] < '1') {
					return reverseAny(x);
				}
			} else if (chars[9] < '2') {
				return reverseAny(x);
			}
			return 0;
		}
		return reverseAny(x);
	}

	public int reverseAny(int x) {
		int reverse = 0;
		while (x != 0) {
			int remainder = x % 10;
			reverse = reverse * 10 + remainder;
			x = x / 10;
		}
		return reverse;
	}
}
