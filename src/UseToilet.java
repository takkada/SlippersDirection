
public class UseToilet {

	/** スリッパの向き(前方) */
	public static final int SLIP_DIRECT_FRONT = 1;
	/** スリッパの向き(後方) */
	public static final int SLIP_DIRECT_BACK = 2;

	/** コスト 何もしない */
	private static final int COST_NO_COST = 0;
	/** コスト スリッパを脱ぐ */
	private static final int COST_TAKE_OFF = 1;
	/** コスト 体の向きを変える */
	private static final int COST_TURN_AROUND = 1;
	/** コスト 用を済ます */
	private static final int COST_EXECUTE = 10;
	/** コスト スリッパを履く */
	private static final int COST_WEAR = 1;

	/**
	 * 実行メソッド。
	 *
	 * @param args 引数
	 */
	public static void main(String[] args) {

		useToilet(SLIP_DIRECT_FRONT, SLIP_DIRECT_FRONT);
		useToilet(SLIP_DIRECT_FRONT, SLIP_DIRECT_BACK);
		useToilet(SLIP_DIRECT_BACK, SLIP_DIRECT_FRONT);
		useToilet(SLIP_DIRECT_BACK, SLIP_DIRECT_BACK);
	}

	/**
	 * トイレを使用します。
	 *
	 * @param insideStatus 入る時のスリッパの向き
	 * @param outsideStatus 出る時のスリッパの向き
	 */
	private static void useToilet(int insideStatus, int outsideStatus) {

		// 消費するコストの初期化
		int cost = 0;

		// 自分のスリッパを脱ぐ
		cost += takeOffSlippers();
		// トイレに入る
		cost += enterToilet(insideStatus);
		// トイレを利用する
		cost += execute();
		// トイレから出る
		cost += exitToilet(outsideStatus);
		// スリッパを履き替える
		cost += changeSlippers(outsideStatus);

		// 結果をコンソールに出力する
		System.out.println(getSlippersDirectionName(insideStatus) + ":" + getSlippersDirectionName(outsideStatus) + "の場合… " + cost);
	}

	/**
	 * 自分のスリッパを脱ぎます。
	 *
	 * @return スリッパを脱ぐためにかかるコスト
	 */
	private static int takeOffSlippers() {
		return COST_TAKE_OFF;
	}

	/**
	 * トイレに入ります。
	 *
	 * @param slippersDirectionStatus 入る時のスリッパの向き
	 * @return トイレに入る際にかかるコスト
	 */
	private static int enterToilet(int slippersDirectionStatus) {

		// スリッパの向きを確認
		if (slippersDirectionStatus == SLIP_DIRECT_FRONT) {
			// 入れる向きの場合、コスト無し
			return COST_NO_COST;
		}
		// 人間の向きを反回転する
		return COST_TURN_AROUND;
	}

	/**
	 * トイレを利用します。
	 *
	 * @return トイレを利用するために消費するコスト
	 */
	private static int execute() {

		// 利用する
		return COST_EXECUTE;
	}

	/**
	 * トイレから出ます。
	 *
	 * @param slippersDirectionStatus 出る時のスリッパの向き
	 * @return トイレを出るときにかかるコスト
	 */
	private static int exitToilet(int slippersDirectionStatus) {

		// スリッパの向きを確認
		if (slippersDirectionStatus == SLIP_DIRECT_FRONT) {
			// 人間の向きを反回転する
			return COST_TURN_AROUND;
		}
		return COST_NO_COST;
	}

	/**
	 * スリッパを履き替えます。
	 *
	 * @param slippersDirectionStatus 出る時のスリッパの向き
	 * @return スリッパを履き替えるために必要なコスト
	 */
	private static int changeSlippers(int slippersDirectionStatus) {

		if (slippersDirectionStatus == SLIP_DIRECT_FRONT) {
			return COST_WEAR;
		}
		// 人間の向きを反回転する
		return COST_TURN_AROUND + COST_WEAR;
	}

	/**
	 * スリッパの向きステータスコードから、名称を取得します。
	 *
	 * @param code スリッパの向きステータスコード
	 * @return 名称
	 */
	private static String getSlippersDirectionName(int code) {

		// 名称(返却用)
		String name = "";

		switch (code) {
		case SLIP_DIRECT_FRONT:
			name = "↑";
			break;

		case SLIP_DIRECT_BACK:
			name = "↓";
			break;
		}

		return name;
	}
}
