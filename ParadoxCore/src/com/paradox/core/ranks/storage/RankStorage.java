package com.paradox.core.ranks.storage;

import java.util.ArrayList;
import java.util.List;

import com.paradox.core.ranks.obj.Rank;

public class RankStorage {
	
	public static List<Rank> getAllRanks(){
		List<Rank> ranks = new ArrayList<>();
		ranks.add(A);
		ranks.add(B);
		ranks.add(C);
		ranks.add(D);
		ranks.add(E);
		ranks.add(F);
		ranks.add(G);
		ranks.add(H);
		ranks.add(I);
		ranks.add(J);
		ranks.add(K);
		ranks.add(L);
		ranks.add(M);
		ranks.add(N);
		ranks.add(O);
		ranks.add(P);
		ranks.add(Q);
		ranks.add(R);
		ranks.add(S);
		ranks.add(T);
		ranks.add(U);
		ranks.add(V);
		ranks.add(W);
		ranks.add(X);
		ranks.add(Y);
		ranks.add(Z);
		return ranks;
		//todo: add all ranks then finish rankutils.
	}
	
	public static Rank A = new Rank("A", 1, 1000, true, false);
	public static Rank B = new Rank("B", 2, 2500, false, false);
	public static Rank C = new Rank("C", 3, 5000, false, false);
	public static Rank D = new Rank("D", 4, 10000, false, false);
	public static Rank E = new Rank("E", 5, 25000, false, false);
	public static Rank F = new Rank("F", 6, 50000, false, false);
	public static Rank G = new Rank("G", 7, 80000, false, false);
	public static Rank H = new Rank("H", 8, 100000, false, false);
	public static Rank I = new Rank("I", 9, 150000, false, false);
	public static Rank J = new Rank("J", 10, 275000, false, false);
	public static Rank K = new Rank("K", 11, 500000, false, false);
	public static Rank L = new Rank("L", 12, 750000, false, false);
	public static Rank M = new Rank("M", 13, 1000000, false, false);
	public static Rank N = new Rank("N", 14, 2500000, false, false);
	public static Rank O = new Rank("O", 15, 3000000, false, false);
	public static Rank P = new Rank("P", 16, 4000000, false, false);
	public static Rank Q = new Rank("Q", 17, 5000000, false, false);
	public static Rank R = new Rank("R", 18, 10000000, false, false);
	public static Rank S = new Rank("S", 19, 15000000, false, false);
	public static Rank T = new Rank("T", 20, 25000000, false, false);
	public static Rank U = new Rank("U", 21, 30000000, false, false);
	public static Rank V = new Rank("V", 22, 50000000, false, false);
	public static Rank W = new Rank("W", 23, 75000000, false, false);
	public static Rank X = new Rank("X", 24, 80000000, false, false);
	public static Rank Y = new Rank("Y", 25, 90000000, false, false);
	public static Rank Z = new Rank("Z", 26, 100000000, false, true);
}
