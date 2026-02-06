<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des Réservations</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            background-color: #f5f5f5;
        }
        h1 {
            color: #333;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            background-color: white;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
        }
        th {
            background-color: #007bff;
            color: white;
            padding: 12px;
            text-align: left;
        }
        td {
            padding: 10px;
            border-bottom: 1px solid #ddd;
        }
        tr:hover {
            background-color: #f1f1f1;
        }
        .back-link {
            display: inline-block;
            margin-bottom: 20px;
            color: #007bff;
            text-decoration: none;
        }
        .back-link:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <a href="/" class="back-link">← Retour à l'accueil</a>
    <h1>Liste des Réservations</h1>
    
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Client</th>
                <th>Date d'arrivee</th>
                <th>Hotel</th>
                <th>Nombre passagers</th>
            </tr>
        </thead>
        <tbody>
           <c:forEach var="r" items="${reservations}">
                <tr>
                    <td>${r.id}</td>
                    <td>${r.client.nom}</td>
                    <td>${r.client.numeroPassport}</td>
                    <td>${r.hotel.nom}</td>
                    <td>${r.dateHeureArrivee}</td>
                    <td>${r.nombrePassager}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
