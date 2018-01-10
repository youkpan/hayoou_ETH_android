<?php
	error_reporting(0);

function post($post_data)
{
	$url = "http://localhost:8545";
	//$post_data = '{"jsonrpc":"2.0","method":"eth_getBalance","params":["0x8bf2df40698ba857dbdff5b460aabfe4913d3595","latest"],"id":1}';//array ("username" => "bob","key" => "12345");

	$ch = curl_init();
	
	curl_setopt($ch, CURLOPT_URL, $url);
	curl_setopt($ch, CURLOPT_TIMEOUT, 15);//设置超时时间

	curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
	// post数据
	curl_setopt($ch, CURLOPT_POST, 1);
	// post的变量
	curl_setopt($ch, CURLOPT_POSTFIELDS, $post_data);
	
	curl_setopt($ch, CURLOPT_HTTPHEADER, array(  
            'Content-Type: application/json; charset=utf-8',  
            'Content-Length: ' . strlen($post_data),
            'Referer:http://hayoou.com/ethwallet/')  
        );  

	$output = curl_exec($ch);
	curl_close($ch);
	//echo "1";
	//print_r($output);
	return $output;
}

$action = $_GET['action'] ;
//http://eth.test/api.php?action=balance&address=0x8bf2df40698ba857dbdff5b460aabfe4913d3595
if ($action == 'balance') {
	$address = $_GET['address'] ;
/*
{"jsonrpc":"2.0","method":"eth_getBalance","params":["0x8bf2df40698ba857dbdff5b460aabfe4913d3595","latest"],"id":11}
result
{"jsonrpc":"2.0","id":11,"result":"0x40f7398f3a87ba000"}
*/
	$re = post('{"jsonrpc":"2.0","method":"eth_getBalance","params":["'.$address.'","latest"],"id":15}');
	$json = json_decode($re);
	//var_dump($json);
	$intv = hexdec(substr($json->result,2));
	//echo substr($json->result,2);
	$txt = sprintf('{"status":"1","message":"OK","result":"%40.0f"}',(float )$intv);
	echo str_replace(" ", "", $txt);
	exit;
}


if ($action == 'eth_blockNumber') {

	$re = post('{"jsonrpc":"2.0","method":"eth_blockNumber","params":["0x0",false],"id":1}');
	echo $re;
	exit;
	}
if ($action == 'txlist') {
	//todo
	echo '{"status":"0","message":"No transactions found","result":[]}';
	exit;
	
	}
?>