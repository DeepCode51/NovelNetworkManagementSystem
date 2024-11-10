<%@ page language="java" contentType="text/html; charset=UTF-8"
         autoFlush="false" buffer="1000kb" pageEncoding="UTF-8"
         import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="/WEB-INF/func.tld" prefix="func"%>


<div class="chart" id="line-chart" style="height: 300px;">
    <svg height="300" version="1.1" width="509.5" xmlns="http://www.w3.org/2000/svg"
         xmlns:xlink="http://www.w3.org/1999/xlink"
         style="overflow: hidden; position: relative; left: -0.5px; top: -0.700012px;">
        <desc>Created with Raphaël 2.3.0</desc>
        <defs></defs>
        <text style="text-anchor: end; font-family: sans-serif; font-size: 12px; font-weight: normal;"
              x="50.54999923706055" y="259" text-anchor="end" font-family="sans-serif" font-size="12px" stroke="none"
              fill="#888888" font-weight="normal">
            <tspan dy="4">0</tspan>
        </text>
        <path style="" fill="none" stroke="#aaaaaa" d="M63.04999923706055,259H484.5" stroke-width="0.5"></path>
        <text style="text-anchor: end; font-family: sans-serif; font-size: 12px; font-weight: normal;"
              x="50.54999923706055" y="200.5" text-anchor="end" font-family="sans-serif" font-size="12px" stroke="none"
              fill="#888888" font-weight="normal">
            <tspan dy="4">5,000</tspan>
        </text>
        <path style="" fill="none" stroke="#aaaaaa" d="M63.04999923706055,200.5H484.5" stroke-width="0.5"></path>
        <text style="text-anchor: end; font-family: sans-serif; font-size: 12px; font-weight: normal;"
              x="50.54999923706055" y="142" text-anchor="end" font-family="sans-serif" font-size="12px" stroke="none"
              fill="#888888" font-weight="normal">
            <tspan dy="4">10,000</tspan>
        </text>
        <path style="" fill="none" stroke="#aaaaaa" d="M63.04999923706055,142H484.5" stroke-width="0.5"></path>
        <text style="text-anchor: end; font-family: sans-serif; font-size: 12px; font-weight: normal;"
              x="50.54999923706055" y="83.5" text-anchor="end" font-family="sans-serif" font-size="12px" stroke="none"
              fill="#888888" font-weight="normal">
            <tspan dy="4">15,000</tspan>
        </text>
        <path style="" fill="none" stroke="#aaaaaa" d="M63.04999923706055,83.5H484.5" stroke-width="0.5"></path>
        <text style="text-anchor: end; font-family: sans-serif; font-size: 12px; font-weight: normal;"
              x="50.54999923706055" y="25" text-anchor="end" font-family="sans-serif" font-size="12px" stroke="none"
              fill="#888888" font-weight="normal">
            <tspan dy="4">20,000</tspan>
        </text>
        <path style="" fill="none" stroke="#aaaaaa" d="M63.04999923706055,25H484.5" stroke-width="0.5"></path>

        <c:forEach items="${range10}" var="i">
            <text style="text-anchor: middle; font-family: sans-serif; font-size: 12px; font-weight: normal;"
                  x="${63+(i-1)*47}" y="271.5" text-anchor="middle" font-family="sans-serif" font-size="12px"
                  stroke="none" fill="#888888" font-weight="normal" transform="matrix(1,0,0,1,0,8)">
                <tspan dy="4">${i}月</tspan>
            </text>
        </c:forEach>

        <path style="" fill="none" stroke="#3c8dbc"
              d="M63.04999923706055,227.8078C74.82806730212447,227.4802,98.3842034322523,229.782175,110.16227149731623,226.4974C121.94033956238015,223.212625,145.496475692508,202.9839163934426,157.2745437575719,201.5296C168.92458934366775,200.0910913934426,192.22468051585943,217.701925,203.87472610195528,214.9261C215.52477168805112,212.150275,238.82486286024277,182.09092909836065,250.47490844633862,179.32299999999998C262.25297651140255,176.52465409836063,285.80911264153036,189.750625,297.58718070659427,192.661C309.36524877165823,195.57137500000002,332.92138490178604,216.4330344262295,344.69945296685,202.606C356.3494985529458,188.92925942622952,379.6495897251375,91.27379350828727,391.2996353112333,82.64589999999998C402.82165841836104,74.11281850828728,425.8657046326166,124.35636785714284,437.3877277397443,133.9621C449.1657958048082,143.78129285714286,472.7219319349361,153.74972499999998,484.5,160.3456"
              stroke-width="3"></path>
        <circle cx="63.04999923706055" cy="227.8078" r="4" fill="#3c8dbc" stroke="#ffffff" style=""
                stroke-width="1"></circle>
        <circle cx="110.16227149731623" cy="226.4974" r="4" fill="#3c8dbc" stroke="#ffffff" style=""
                stroke-width="1"></circle>
        <circle cx="157.2745437575719" cy="201.5296" r="4" fill="#3c8dbc" stroke="#ffffff" style=""
                stroke-width="1"></circle>
        <circle cx="203.87472610195528" cy="214.9261" r="4" fill="#3c8dbc" stroke="#ffffff" style=""
                stroke-width="1"></circle>
        <circle cx="250.47490844633862" cy="179.32299999999998" r="4" fill="#3c8dbc" stroke="#ffffff" style=""
                stroke-width="1"></circle>
        <circle cx="297.58718070659427" cy="192.661" r="4" fill="#3c8dbc" stroke="#ffffff" style=""
                stroke-width="1"></circle>
        <circle cx="344.69945296685" cy="202.606" r="4" fill="#3c8dbc" stroke="#ffffff" style=""
                stroke-width="1"></circle>
        <circle cx="391.2996353112333" cy="82.64589999999998" r="4" fill="#3c8dbc" stroke="#ffffff" style=""
                stroke-width="1"></circle>
        <circle cx="437.3877277397443" cy="133.9621" r="4" fill="#3c8dbc" stroke="#ffffff" style=""
                stroke-width="1"></circle>
        <circle cx="484.5" cy="160.3456" r="4" fill="#3c8dbc" stroke="#ffffff" style="" stroke-width="1"></circle>
    </svg>
    <div class="morris-hover morris-default-style" style="left: 65.1123px; top: 158px; display: none;">
        <div class="morris-hover-row-label">2011 Q2</div>
        <div class="morris-hover-point" style="color: #3c8dbc">
            Item 1:
            2,778
        </div>
    </div>
</div>