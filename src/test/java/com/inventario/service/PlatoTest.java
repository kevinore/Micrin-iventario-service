package com.inventario.service;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.inventario.service.models.Plato;
import com.inventario.service.repository.PlatoRepository;
import com.inventario.service.services.PlatoService;
import com.inventario.service.services.PlatoServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
class PlatoTest {

	@Autowired
	private PlatoService platoService;
}
