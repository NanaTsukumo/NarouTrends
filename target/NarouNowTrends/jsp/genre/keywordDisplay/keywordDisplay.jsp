<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

		<% DateTimeFormatter japaneseTimeFormat = DateTimeFormatter.ofPattern("yyyy年 MM月 dd日(E曜日) kk時 mm分 ss秒");
			String formatTime = updateTime.format(japaneseTimeFormat);
		%>

		<p>最終更新：<%= formatTime %></p>

    <h2>日間トレンド</h2>
				
					<table border="1">
						<tr>
							<th class="th-left">キーワード設定数</th>
							<th class="th-right">キーワード</th>
						</tr>
						<!-- <p>日間キーワード全体
						<%= dailyList %></p> -->
						<% for(int i = 0; i < number; i++) { %>
						<tr>
							<td><%= dailyList.get(i).getQuantity() %></td>
							<td><%= dailyList.get(i).getKeyword() %></td>
						</tr>
						<% } %>
					</table>
				
				<h2>週間トレンド</h2>
				
				<table border="1">
						<tr>
							<th class="th-left">キーワード設定数(降順)</th>
							<th class="th-right">キーワード</th>
						</tr>
						<!-- <p>週間キーワード全体
						<%= weeklyList %></p> -->
						<% for(int i = 0; i < number; i++) { %>
						<tr>
							<td><%= weeklyList.get(i).getQuantity() %></td>
							<td><%= weeklyList.get(i).getKeyword() %></td>
						</tr>
						<% } %>
					</table>
				
				<h2>月間トレンド</h2>
				
				<table border="1">
						<tr>
							<th class="th-left">キーワード設定数(降順)</th>
							<th class="th-right">キーワード</th>
						</tr>
						<!-- <p>月間キーワード全体
						<%= monthlyList %></p> -->
						<% for(int i = 0; i < number; i++) { %>
						<tr>
							<td><%= monthlyList.get(i).getQuantity() %></td>
							<td><%= monthlyList.get(i).getKeyword() %></td>
						</tr>
						<% } %>
					</table>
				
				<h2>四半期トレンド</h2>
				
				<table border="1">
						<tr>
							<th class="th-left">キーワード設定数(降順)</th>
							<th class="th-right">キーワード</th>
						</tr>
						<!-- <p>四半期キーワード全体
						<%= quarterList %></p> -->
						<% for(int i = 0; i < number; i++) { %>
						<tr>
							<td><%= quarterList.get(i).getQuantity() %></td>
							<td><%= quarterList.get(i).getKeyword() %></td>
						</tr>
						<% } %>
					</table>
				
				<h2>年間トレンド</h2>
				
				<table border="1">
						<tr>
							<th class="th-left">キーワード設定数(降順)</th>
							<th class="th-right">キーワード</th>
						</tr>
						<!-- <p>年間キーワード全体
						<%= yearlyList %></p> -->
						<% for(int i = 0; i < number; i++) { %>
						<tr>
							<td><%= yearlyList.get(i).getQuantity() %></td>
							<td><%= yearlyList.get(i).getKeyword() %></td>
						</tr>
						<% } %>
					</table>
				
				<h2>累計トレンド</h2>
				
				<table border="1">
						<tr>
							<th class="th-left">キーワード設定数(降順)</th>
							<th class="th-right">キーワード</th>
						</tr>
						<!-- <p>累計キーワード全体
						<%= cumulativeList %></p> -->
						<% for(int i = 0; i < number; i++) { %>
						<tr>
							<td><%= cumulativeList.get(i).getQuantity() %></td>
							<td><%= cumulativeList.get(i).getKeyword() %></td>
						</tr>
						<% } %>
					</table>