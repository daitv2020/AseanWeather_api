package com.vti.mock.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.vti.mock.entity.User;

public class UserSpecification implements Specification<User> {


	private static final long serialVersionUID = 1L;

	private String key;
	private String operator;
	private Object value;

	public UserSpecification(String key, String operator, Object value) {
		this.key = key;
		this.operator = operator;
		this.value = value;
	}

	@Override
	public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

		if (operator.equalsIgnoreCase("=")) {
			return criteriaBuilder.equal(root.<String>get(key), value.toString());
		}

		if (operator.equalsIgnoreCase("<")) {
			return criteriaBuilder.lessThan(root.<String>get(key), value.toString());
		}

		if (operator.equalsIgnoreCase(">")) {
			return criteriaBuilder.greaterThan(root.<String>get(key), value.toString());
		}

		if (operator.equalsIgnoreCase("LIKE")) {
			return criteriaBuilder.like(root.<String>get(key), value.toString() + "%");
		}

		return null;
	}
}
