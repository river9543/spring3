package com.medly.sbb;

import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.springframework.stereotype.Component;

@Component//스프링부트가 빈으로 등록된다
public class CommonUtil {
	public String markdown(String markdown) {
		Parser parser=Parser.builder().build();//분석기 생성
		Node document=parser.parse(markdown);//트리구조 html객체
		HtmlRenderer renderer=HtmlRenderer.builder().build();//html변환기
		return renderer.render(document);//html변환기로 트리구조 html객체 반환
	}

}
