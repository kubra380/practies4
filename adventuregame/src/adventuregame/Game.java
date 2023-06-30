package adventuregame;
import java.util.*;

public class Game {
	private Scanner input=new Scanner(System.in);
	public void start() {
		System.out.println("Mecara oyununa hoşgeldiniz!");
		System.out.print("Lütfen bir isim giriniz:");
		String playerName=input.nextLine();
		Player player=new Player(playerName);
		System.out.println(player.getName()+" Hoşgelidiniz!");
		System.out.println("Lütfen oyuna başlamak için karakter seçiniz!");
		System.out.println("----------------------------------");
		player.selectChar();

		Location location=null;
		while(true) {
				player.printInfo();
				System.out.println();
				System.out.println("-------------BÖLGELER-------------");
				System.out.println();
				System.out.println("1-Güvenli Ev-->Burası sizin için güvenli bir ev düşman yok!");
				System.out.println("2-Mağaza-->Silah veya zırh alabilirsiniz!");
				System.out.println("3-Mağara-->Ödül(Yemek),Mağaraya gir,dikkatli ol zombi çıkabilir!");
				System.out.println("4-Orman-->Ödül(Odun),Ormana gir,dikkatli ol vampir çıkabilir!");
				System.out.println("5-Nehir-->Ödül(Su),Nehire gir,dikkatli ol ayı çıkabilir!");
				System.out.print("Lütfen gitmek istediğiniz bölgeyi seçiniz:");
				int selectLoc=input.nextInt();
				
				switch(selectLoc) {
				case 1:
					location=new SafeHouse(player);
					break;
				case 2:
					location=new ToolStore(player);
					break;
				case 3:
					location=new Cave(player);
					break;
				case 4:
					location=new Forest(player);
					break;	
					
				case 5:
					location=new River(player);
					break;
				default:
					System.out.println("Lütfen geçerli bir bölge giriniz!");
					break;
				
				}
				if(!location.onLocation()) {
					System.out.println("GAME OVER");
					break;
				}
			}
		
		
	}
}
