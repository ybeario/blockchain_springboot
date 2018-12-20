package com.cqupt.bear.blockchain.evidence.web;

import java.io.File;
import java.io.IOException;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.cqupt.bear.blockchain.evidence.dto.EvidenceInfo;

/**
 * @author Y.bear
 * @version 创建时间：2018年11月30日 下午7:21:57 类说明
 */
@Controller
@RequestMapping("/user")
public class UserController {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@PostMapping("/file")
	public ModelAndView upload(MultipartFile evidence, ModelAndView modelAndView, String identityCard, String telephone,
			String email) throws IllegalStateException, IOException {
		String originalFilename = evidence.getOriginalFilename();
		String md5 = DigestUtils.md5Hex(evidence.getBytes());
		String folder=System.getProperty("user.dir")+"\\evidences";
		File localFile = new File(folder, originalFilename);
		evidence.transferTo(localFile);
		EvidenceInfo evidenceInfo = new EvidenceInfo(md5, "0001", "A01", "0005");
		logger.info("文件：\""+originalFilename + "\"成功写入，" + "相关信息为：" + evidenceInfo.toString());
		modelAndView.addObject(evidenceInfo);
		modelAndView.setViewName("user/uploadSuccess");
		return modelAndView;
	}
}
