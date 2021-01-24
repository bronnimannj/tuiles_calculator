package tuiles_calculator;

public class ExamplesInput {

	Object[][] ImputTable;
	
	public ExamplesInput(String str) {
		if(str == "Default") {
			ImputTable = new Object[][] {
				{"A",   null, null, null, false},
				{"B",   null, null, null, false},
				{"C",   null, null, null, false},
				{"D",   null, null, null, false},
				{"E",   null, null, null, false},
				{"F",   null, null, null, false},
				{"G",   null, null, null, false},
				{"H",   null, null, null, false},
				{"I",   null, null, null, false},
				{"J",   null, null, null, false},
				{"K",   null, null, null, false},
				{"...", null, null, null, false},
				{null,  null, null, null, false},
				{null,  null, null, null, false},
				{null,  null, null, null, false},
				{null,  null, null, null, false},
				{null,  null, null, null, false},
				{null,  null, null, null, false},
				{null,  null, null, null, false},
				{null,  null, null, null, false},
				{null,  null, null, null, false},
				{null,  null, null, null, false},
				{null,  null, null, null, false},
				{null,  null, null, null, false},
				{null,  null, null, null, false},
				{null,  null, null, null, false},
				{null,  null, null, null, false},
				{null,  null, null, null, false},
				{null,  null, null, null, false},
				{null,  null, null, null, false}};
		}else if(str == "Example1") {
			ImputTable = new Object[][] {
				{"A",  0.0    ,   0.0  , 90.0  , true},
				{"B",  2100.0 ,   0.0  , 17.0  , true},
				{"B1", 2100.0 ,  -1.0  , 47.625, false},
				{"C",  5660.0 , -500.0 , 90.0  , true},
				{"D",  9220.0 ,  -1.0  , 90.0  , true},
				{"D1", 9220.0 ,   0.0  , 47.625, false},
				{"E",  12700.0,   0.0  , 17.0  , true},
				{"F",  12700.0, -1400.0, 47.625, false},
				{"G",  16260.0, -1900.0, 90.0  , true},
				{"H",  19820.0, -1400.0, 90.0  , true},
				{"I",  19820.0,   0.0  , 47.625, false},
				{"J",  21920.0,   0.0  , 17.0  , true},
				{"K",  21920.0, 11200.0, 90.0  , true},
				{"L",  19820.0, 11200.0, 17.0  , true},
				{"L1", 19820.0, 11201.0, 47.625, false},
				{"M",  16260.0, 11700.0, 90.0  , true},
				{"N",  12700.0, 11201.0, 90.0  , true},
				{"N1", 12700.0, 11200.0, 47.625, false},
				{"O",  9220.0 , 11200.0, 17.0  , true},
				{"P",  9220.0 , 12600.0, 47.625, false},
				{"Q",  5660.0 , 13100.0, 90.0  , true},
				{"R",  2100.0 , 12600.0, 90.0  , true},
				{"S",  2100.0 , 11200.0, 47.625, false},
				{"T",  0.0    , 11200.0, 17.0  , true}};
		}
		
	}
	
	public Object[][] table(){
		return ImputTable;
	}
	
}
