package ProjectEuler;

public class Problem24 {
	private static String getPoss(){
		int co = 0;
		String p = "";
		int a,b,c,d,e,f,g,h,i,j;
		all: for(a = 0; a < 10; a++){
			for(b = 0; b < 10; b++){
				for(c = 0; c < 10; c++){
					for(d= 0; d < 10; d++){
						for(e = 0; e < 10; e++){
							for(f = 0; f < 10; f++){
								for(g = 0; g < 10; g++){
									for(h = 0; h < 10; h++){
										for(i = 0; i < 10; i++){
											for (j = 0; j < 10; j++){
												if (a != b && a != c && a != d && a != e && a != f && a != g && a != h && a != i && a != j &&
															  b != c && b != d && b != e && b != f && b != g && b != h && b != i && b != j &&
															  			c != d && c != e && c != f && c != g && c != h && c != i && c != j &&
															  					  d != e && d != f && d != g && d != h && d != i && d != j &&
															  					  			e != f && e != g && e != h && e != i && e != j &&
															  					  					  f != g && f != h && f != i && f != j &&
															  					  					  			g != h && g != i && g != j &&
															  					  					  					  h != i && h != j &&
															  					  					  					  			i != j
													){ // Can only have one of each digit
													co++;
													p = "" + a + b + c + d + e + f + g + h + i + j;
													System.out.println(co + ". " + p);
													if(co == 1000000){
														break all;
													} // if
												} // if
											} // j
										} // i
									} // h
								} // g
							} // f
						} // e
					} // d
				} // c
			} // b
		} // a
		return p;
	}
	
	public static void main(String[] args) {
		System.out.println("Running, I promise!");
		System.out.println(getPoss()); // 1000000th number from zero index
	}

}
