package edu.sjsu.cs272.assignment.model;

import java.io.Serializable;

/*
 * Table : BusinessToCheckin
 */
public class CheckIn implements Serializable {

	private static final long serialVersionUID = -3928106508044186035L;

	public CheckIn(DAY day, HOUR hour, int count, String business_id,
			String type) {
		this.day = day;
		this.hour = hour;
		this.count = count;
		this.business_id = business_id;
		this.type = type;
	}

	public CheckIn() {
	}

	public static enum DAY {
		SUNDAY(0), MONDAY(1), TUESDAY(2), WEDNESDAY(3), THURSDAY(4), FRIDAY(5), SATURDAY(
				6), UNKNOWN(-1);

		private DAY(int value) {
			this.value = value;
		}

		public int value;

		public static DAY getType(int value) {
			DAY day = UNKNOWN;
			switch (value) {
			case 0:
				day = SUNDAY;
				break;
			case 1:
				day = MONDAY;
				break;
			case 2:
				day = TUESDAY;
				break;
			case 3:
				day = WEDNESDAY;
				break;
			case 4:
				day = THURSDAY;
				break;
			case 5:
				day = FRIDAY;
				break;
			case 6:
				day = SATURDAY;

			}
			return day;
		}
	}

	public static enum HOUR {
		_0_TO_1(0), _1_TO_2(1), _2_TO_3(2), _3_TO_4(3), _4_TO_5(4), _5_TO_6(5), _6_TO_7(
				6), _7_TO_8(7), _8_TO_9(8), _9_TO_10(9), _10_TO_11(10), _11_TO_12(
				11), _12_TO_13(12), _13_TO_14(13), _14_TO_15(14), _15_TO_16(15), _16_TO_17(
				16), _17_TO_18(17), _18_TO_19(18), _19_TO_20(19), _20_TO_21(20), _21_TO_22(
				21), _22_TO_23(22), _23_TO_24(23), UNKNOWN(-1);

		private HOUR(int value) {
			this.value = value;
		}

		public int value;

		public static HOUR getType(int value) {
			HOUR hour = UNKNOWN;
			switch (value) {
			case 0:
				hour = _0_TO_1;
				break;
			case 1:
				hour = _1_TO_2;
				break;
			case 2:
				hour = _2_TO_3;
				break;
			case 3:
				hour = _3_TO_4;
				break;
			case 4:
				hour = _4_TO_5;
				break;
			case 5:
				hour = _5_TO_6;
				break;
			case 6:
				hour = _6_TO_7;
				break;
			case 7:
				hour = _7_TO_8;
				break;
			case 8:
				hour = _8_TO_9;
				break;
			case 9:
				hour = _9_TO_10;
				break;
			case 10:
				hour = _10_TO_11;
				break;
			case 11:
				hour = _11_TO_12;
				break;
			case 12:
				hour = _12_TO_13;
				break;
			case 13:
				hour = _13_TO_14;
				break;
			case 14:
				hour = _14_TO_15;
				break;
			case 15:
				hour = _15_TO_16;
				break;
			case 16:
				hour = _16_TO_17;
				break;
			case 17:
				hour = _17_TO_18;
				break;
			case 18:
				hour = _18_TO_19;
				break;
			case 19:
				hour = _19_TO_20;
				break;
			case 20:
				hour = _20_TO_21;
				break;
			case 21:
				hour = _21_TO_22;
				break;
			case 22:
				hour = _22_TO_23;
				break;
			case 23:
				hour = _23_TO_24;
				break;
			}
			return hour;
		}
	}

	public DAY day;
	public HOUR hour;
	public int count;
	public String business_id;
	public String type;
}
