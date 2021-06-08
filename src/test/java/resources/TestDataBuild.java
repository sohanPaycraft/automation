package resources;

import Pojo.Logon;
import Pojo.Parameter;

import java.util.ArrayList;
import java.util.List;

import Pojo.BalanceEnquiry;
import Pojo.EncFieldInfoList;
import Pojo.OnlineSale;
import Pojo.TopUp;
import Pojo.OperatorKey;
import Pojo.KeyInjection;
public class TestDataBuild {
	
	public Logon logonPayload(String appVersionNumber  ,String MerchantID
			,String MerchantNameLoc , String PosSerialNumber , String ProcessingCode , String ReqId , String setStan ,
			String TerminalId)
	{
		Logon l =new Logon();
		l.setAppVersionNumber(appVersionNumber);
		l.setInvoiceNumber("100003");
		l.setLocalDate("0528");
		l.setLocalTime("145956");
		l.setMerchantID(MerchantID);
		l.setMerchantNameLoc(MerchantNameLoc);
		l.setPosSerialNumber(PosSerialNumber);
		l.setProcessingCode(ProcessingCode);
		l.setReqId(ReqId);
		l.setStan(setStan);
		l.setTerminalId(TerminalId);
		return l;
		
	}
	
	public Parameter parameterPayload(String appVersionNumber,String batchNumber,String merchantID,
			String posSerialNumber,String processingCode,
			String reqId,String stan,String terminalId) {
		Parameter p= new Parameter();
		p.setAppVersionNumber(appVersionNumber);
		p.setBatchNumber(batchNumber);
		p.setField60("00");
		p.setInvoiceNumber("100004");
		p.setLocalDate("0528");
		p.setLocalTime("145956");
		p.setMerchantID(merchantID);
		p.setMerchantNameLoc("MMOPL");
		p.setPosSerialNumber(posSerialNumber);
		p.setProcessingCode(processingCode);
		p.setReqId(reqId);
		p.setStan(stan);
		p.setTerminalId(terminalId);
		return p;
	}

	
	public BalanceEnquiry bePayload(String ChipData,String amount,String appVersionNumber,String batchNumber
			,String invoiceNumber,String merchantID,String merchantNameLoc
			,String nii,String posEntryMode,String posSerialNumber,
			String processingCode,String reqId,String stan,String terminalId,
			String track2Data) {
		BalanceEnquiry b=new BalanceEnquiry();
		EncFieldInfoList e1=new EncFieldInfoList();
		EncFieldInfoList e2=new EncFieldInfoList();
		b.setAmount(amount);
		b.setAppVersionNumber(appVersionNumber);
		b.setBatchNumber(batchNumber);
		b.setInvoiceNumber(invoiceNumber);
		b.setLocalDate("0526");
		b.setLocalTime("205247");
		b.setMerchantID(merchantID);
		b.setMerchantNameLoc(merchantNameLoc);
		b.setNii(nii);
		b.setPinBlock("92ed26d59aed2c87");
		b.setPosCondCode("00");
		b.setPosEntryMode(posEntryMode);
		b.setPosSerialNumber(posSerialNumber);
		b.setProcessingCode(processingCode);
		b.setReqId(reqId);
		b.setStan(stan);
		b.setTerminalId(terminalId);
		List<EncFieldInfoList> en =new ArrayList<EncFieldInfoList>();
		e1.setFieldNumber("35");
		e1.setKsn("00141101003227000008");
		e2.setFieldNumber("52");
		e2.setKsn("00141101003227000007");
		en.add(e1);
		en.add(e2);
		b.setEncFieldInfoList(en);
		b.setUniqueTransactionRefNo("1622042553934");
		if(track2Data.matches("")) 
		{b.setTrack2Data(track2Data);}
		else {b.setTrack2Data("ece74646e099c54adbb50e3c3f9565fb5d5f18d45d90218f");}
		if(ChipData.matches("")) {
			b.setChipData(ChipData);
		}else {
			b.setChipData("5F2A0203565F340101820219008407a00000052410108E0E000000000000000042031f031e03950500000408009A032105269C01319F02060000000000009F03060000000000009F0607a00000052410109F090200029F10200fb501a8000000000000000000000000000000000000000000000000000000009F1A0203569F1E0830303030303132339F260856e99ba40c48bc8a9F2701809F3303e0e9c89F34034203009F3501229F3602001a9F3704e4b8b95dDF15029180");
		}
		
			return b;
	}
	
	public OnlineSale onlineSale(String amount,String appVersionNumber,String batchNumber,String ChipData,
			String invoiceNumber,String merchantID,String merchantNameLoc,String nii,
			String posEntryMode,String posSerialNumber,String processingCode,String reqId,String stan,
			String terminalId,String track2Data) {
		OnlineSale o=new OnlineSale();
		EncFieldInfoList e1=new EncFieldInfoList();
		EncFieldInfoList e2=new EncFieldInfoList();
		o.setAmount(amount);
		o.setAppVersionNumber(appVersionNumber);
		o.setBatchNumber(batchNumber);
		o.setChipData(ChipData);
		o.setInvoiceNumber(invoiceNumber);
		o.setLocalDate("0526");
		o.setLocalTime("210251");
		o.setMerchantID(merchantID);
		o.setMerchantNameLoc(merchantNameLoc);
		o.setNii(nii);
		o.setPinBlock("759fe1818e320ef3");
		o.setPosCondCode("00");
		o.setPosEntryMode(posEntryMode);
		o.setPosSerialNumber(posSerialNumber);
		o.setProcessingCode(processingCode);
		o.setProcessingCode(processingCode);
		o.setReqId(reqId);
		o.setStan(stan);
		o.setTerminalId(terminalId);
		o.setTxnSubTypeDesc("Pass");
		o.setTxnSubTypeId("0004");
		o.setUniqueTransactionRefNo("1622043159500");
		List<EncFieldInfoList> en =new ArrayList<EncFieldInfoList>();
		e1.setFieldNumber("35");
		e1.setKsn("0014110100322700000c");
		e2.setFieldNumber("52");
		e2.setKsn("0014110100322700000b");
		en.add(e1);
		en.add(e2);
		o.setEncFieldInfoList(en);
		
		if(track2Data.matches("")) 
		{o.setTrack2Data(track2Data);}
		else {o.setTrack2Data("6fe6e82a3d2a99284eccd133a6bbf5695dd163f9296c69bd");}
		if(ChipData.matches("")) {
			o.setChipData(ChipData);
		}else {
			o.setChipData("5F2A0203565F340101820219008407a00000052410108E0E000000000000000042031f031e03950500000488009A032105269C01009F02060000000000019F03060000000000009F0607a00000052410109F090200029F10200fb501a8000000000000000000000100000000000000000000000000000000009F1A0203569F1E0830303030303132339F2608414be97c204eec8d9F2701809F3303e0e9c89F34034203009F3501229F360200209F37048a8c7591DF15029180");
		}
		return o;
	}
	
	public TopUp topUpPayload(String amount,String appVersionNumber,String batchNumber,String ChipData,
			String fundingSource,String invoiceNumber,String merchantID,String merchantNameLoc,
			String nii,String posEntryMode,String posSerialNumber,String processingCode,
			String reqId,String stan,String terminalId,String track2Data) {
		TopUp t=new TopUp();
		EncFieldInfoList e1=new EncFieldInfoList();
		EncFieldInfoList e2=new EncFieldInfoList();
		t.setAmount(amount);
		t.setAppVersionNumber(appVersionNumber);
		t.setBatchNumber(batchNumber);
		t.setFundingSource(fundingSource);
		t.setInvoiceNumber(invoiceNumber);
		t.setLocalDate("0526");
		t.setLocalTime("205645");
		t.setMerchantID(merchantID);
		t.setMerchantNameLoc(merchantNameLoc);
		t.setNii(nii);
		t.setPinBlock("f402cdd4b16f9d98");
		t.setPosCondCode("00");
		t.setPosEntryMode(posEntryMode);
		t.setPosSerialNumber(posSerialNumber);
		t.setProcessingCode(processingCode);
		t.setReqId(reqId);
		t.setRrn("null");
		t.setStan(stan);
		t.setTerminalId(terminalId);
		t.setTxnSubTypeDesc("");
		t.setTxnSubTypeId("");
		t.setUniqueTransactionRefNo("1622042794179");
		List<EncFieldInfoList> en =new ArrayList<EncFieldInfoList>();
		e1.setFieldNumber("35");
		e1.setKsn("0014110100322700000a");
		e2.setFieldNumber("52");
		e2.setKsn("00141101003227000009");
		en.add(e1);
		en.add(e2);
		t.setEncFieldInfoList(en);
		if(track2Data.matches("")) 
		{t.setTrack2Data(track2Data);}
		else {t.setTrack2Data("20e4d1af94aa7c57170dfe157bde9cc4bc9d9e754c90f65b");}
		if(ChipData.matches("")) {
			t.setChipData(ChipData);
		}else {
			t.setChipData("5F2A0203565F340101820219008407a00000052410108E0E000000000000000042031f031e03950500000488009A032105269C01009F02060000000000019F03060000000000009F0607a00000052410109F090200029F10200fb501a8000000000000000000000100000000000000000000000000000000009F1A0203569F1E0830303030303132339F2608414be97c204eec8d9F2701809F3303e0e9c89F34034203009F3501229F360200209F37048a8c7591DF15029180");
		}
		return t;
	}
	
	public OperatorKey operatorPayload(String appVersionNumber,String csaKeyVersionNo,String exponent,
			String idsBinVersionNo,String idsKeyVersionNo,String merchantID,
			String modulus,String osaKeyVersionNo,String posSerialNumber,String processingCode,
			String reqId,String stan,String terminalId ) {
		
		OperatorKey o= new OperatorKey();
		o.setAppVersionNumber(appVersionNumber);
		o.setCsaKeyVersionNo(csaKeyVersionNo);
		o.setExponent(exponent);
		o.setIdsBinVersionNo(idsBinVersionNo);
		o.setIdsKeyVersionNo(idsKeyVersionNo);
		o.setLocalDate("0528");
		o.setLocalTime("145954");
		o.setMerchantID(merchantID);
		if(modulus==null) {o.setModulus(modulus);}else {
		o.setModulus("9C5A6171EDA1C05506B6744CD61E29480FB8310D573A5953C3AE86EFCB5EC20C2327EDCB8CDD6C8EE44342FC6C53CD95AFA7B5AD305BD5EF0E0EB1C0CC4EB260E9BF1C15FA0BCF1BD4AD7EB48E2D471563A2B9E7D3A0A48B15BE419545125EA52FB1AEE8D2649ED181F816EF2B76975BB09357F89D04E79AC6C7E60BF1B12A7C2BD5C6D89B3DA5CA8F195F4C4EF48471C36390856556EF1B90F57F19073EC1F93F8723726FCB48283ACBA40EE047DDEB6BD569A68E54D5EBD48D53D4C6359DDDE05CAC580074D93F8628AC5B3826049A6E1DBE28F6C70C2306C4B601469FA1C0914424EEAFF4FBF12C5EC5CFC3F4512E186526A3485935552E8AE21107796EB7");}
		o.setNii("00");
		o.setOsaKeyVersionNo(osaKeyVersionNo);
		o.setPosSerialNumber(posSerialNumber);
		o.setProcessingCode(processingCode);
		o.setReqId(reqId);
		o.setStan(stan);
		o.setTerminalId(terminalId);
		return o;
	}
	
	public KeyInjection keyinjectionPayload(String appVersionNumber,String exponent,String modulus,
			String posSerialNumber,String processingCode,String reqId,String stan) {
		KeyInjection k= new KeyInjection();
		k.setAppVersionNumber(appVersionNumber);
		k.setExponent(exponent);
		k.setInvoiceNumber("100001");
		k.setLocalDate("0528");
		k.setLocalTime("145946");
		if(modulus==null) {k.setModulus(modulus);}else {
		k.setModulus("D0A6BC8053D242096106473BE25F45F9924FC86871381D81CAB9EE04C51CFC5D27C9F698E45D344F3A9E32215DEEE5E744E31B2AA81AC9C05528564BA6084C8AF2F9D5C77FCA3D99A533C562AB4D2E7CEBD2E636620018D36CD7944771333FB5CD4CA1D63BFAF77650092F50695D2127F15C9FDB1152457D19BD2042D4EE8A22F2048FD5EE4701E63B6ABE30C0BCD3FA87EB2B5CA59752C5318ACB0B17E9366B7B251BE426BDCE514DFFF2891D43DC1315EB95085D650C2A90FAB54B6440F45C311A38219E70D38DF3D22196C65D97C905491A22910D0EA292231B0243A6B2437752FF83E5D7941ADE4D1805B418517EE549C8471D4AECCCC47D45862016F3A7");}
		k.setPosSerialNumber(posSerialNumber);
		k.setProcessingCode(processingCode);
		k.setReqId(reqId);
		k.setStan(stan);
		
		
		return k;
	}
	
}
