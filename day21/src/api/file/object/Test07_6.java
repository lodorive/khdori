package api.file.object;

import java.io.IOException;

public class Test07_6 {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		//파일이 있을 때와 없을 때 모두 처리되도록 구현
		Player player = GameUtil.load();
		player.levelUp();
		player.show();
		GameUtil.save(player);
	}
}


