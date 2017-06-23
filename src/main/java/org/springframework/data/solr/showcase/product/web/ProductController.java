/*
 * Copyright 2012 - 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.data.solr.showcase.product.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.solr.showcase.product.ProductService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerMapping;

/**
 * @author Christoph Strobl
 */
@Controller
@Component
@Scope("prototype")
public class ProductController {

	@Autowired
	private ProductService productService;



	@RequestMapping("/product/**")
	public String search(Model model, HttpServletRequest request) {
		String id = extractId(request);
		model.addAttribute("product", productService.findById(id));
		return "product";
	}

	private String extractId(final HttpServletRequest request) {
		// path='/product/EN7800GTX/2DHTV/256M'
		String path = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		// bestMatchPattern='/product/**'
		String bestMatchPattern = (String) request.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE);
		// returns:EN7800GTX/2DHTV/256M
		return new AntPathMatcher().extractPathWithinPattern(bestMatchPattern, path);
	}

}
