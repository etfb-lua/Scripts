-- ts file was generated at discord.gg/25ms - Cleaned and Fixed

local genv = getgenv()
local Players = game:GetService('Players')
local RunService = game:GetService('RunService')
local LocalPlayer = Players.LocalPlayer

-- Initialize Global Variables
genv.AUTO_MYTHICAL = false
genv.AUTO_SECRET = false
genv.AUTO_MONEY = false
genv.AUTO_SPEED_1 = false
genv.AUTO_SPEED_10 = false
genv.AUTO_REBIRTH = false
genv.AUTO_REMOVE_WAVE = false

-- Character Setup
local Character = LocalPlayer.Character or LocalPlayer.CharacterAdded:Wait()
Character:WaitForChild('Humanoid')
Character:WaitForChild('HumanoidRootPart')

LocalPlayer.CharacterAdded:Connect(function(newChar)
    newChar:WaitForChild('Humanoid')
    newChar:WaitForChild('HumanoidRootPart')
end)

-----------------------------------
-- AUTO FARM LOOPS
-----------------------------------

task.spawn(function()
    while task.wait(0.6) do
        if genv.AUTO_MYTHICAL then
            -- [PLACEHOLDER] Put your Mythical roll/claim code here
        end
    end
end)

task.spawn(function()
    while task.wait(0.6) do
        if genv.AUTO_SECRET then
            -- [PLACEHOLDER] Put your Secret roll/claim code here
        end
    end
end)

task.spawn(function()
    while task.wait(10) do
        if genv.AUTO_MONEY then
            -- [PLACEHOLDER] Put your Money collection code here
        end
    end
end)

task.spawn(function()
    while task.wait(0.5) do
        if genv.AUTO_SPEED_1 then
            -- [PLACEHOLDER] Put your Speed +1 code here
        end
    end
end)

task.spawn(function()
    while task.wait(0.5) do
        if genv.AUTO_SPEED_10 then
            -- [PLACEHOLDER] Put your Speed +10 code here
        end
    end
end)

task.spawn(function()
    while task.wait(3) do
        if genv.AUTO_REBIRTH then
            -- [PLACEHOLDER] Put your Auto Rebirth code here
        end
    end
end)

task.spawn(function()
    while task.wait(0.2) do
        if genv.AUTO_REMOVE_WAVE then
            -- [PLACEHOLDER] Put your Remove Wave code here
        end
    end
end)

-----------------------------------
-- GUI SETUP
-----------------------------------

-- Create ScreenGui
local ScreenGui = Instance.new('ScreenGui')
ScreenGui.Name = 'OsakaTP2_V1_Fixed'
ScreenGui.ResetOnSpawn = false
ScreenGui.Parent = LocalPlayer:WaitForChild('PlayerGui')

-- Main Frame
local MainFrame = Instance.new('Frame', ScreenGui)
MainFrame.Size = UDim2.fromOffset(220, 250)
MainFrame.Position = UDim2.fromScale(0.5, 0.5)
MainFrame.AnchorPoint = Vector2.new(0.5, 0.5)
MainFrame.BackgroundColor3 = Color3.fromRGB(30, 30, 30)
MainFrame.BorderSizePixel = 0
local UICorner_Main = Instance.new('UICorner', MainFrame)
UICorner_Main.CornerRadius = UDim.new(0, 14)

-- Title Label
local TitleLabel = Instance.new('TextLabel', MainFrame)
TitleLabel.Size = UDim2.new(1, 0, 0, 36)
TitleLabel.BackgroundTransparency = 1
TitleLabel.Text = 'OsakaTP2 V1 (Fixed)'
TitleLabel.Font = Enum.Font.GothamBold
TitleLabel.TextSize = 13
TitleLabel.TextColor3 = Color3.new(1, 1, 1)

-- Hamburger Menu Toggle
local HamburgerBtn = Instance.new('TextButton', ScreenGui)
HamburgerBtn.Name = 'HamburgerToggle'
HamburgerBtn.Size = UDim2.fromOffset(44, 44)
HamburgerBtn.Position = UDim2.fromOffset(12, 12)
HamburgerBtn.BackgroundColor3 = Color3.fromRGB(50, 50, 50)
HamburgerBtn.Text = '\u{2261}'
HamburgerBtn.TextColor3 = Color3.fromRGB(255, 255, 255)
HamburgerBtn.Font = Enum.Font.GothamBold
HamburgerBtn.TextSize = 22
HamburgerBtn.BorderSizePixel = 0
HamburgerBtn.ZIndex = 100
local UICorner_Hamburger = Instance.new('UICorner', HamburgerBtn)
UICorner_Hamburger.CornerRadius = UDim.new(1, 0)
local UIStroke_Hamburger = Instance.new('UIStroke', HamburgerBtn)
UIStroke_Hamburger.Thickness = 1.5
UIStroke_Hamburger.Color = Color3.fromRGB(90, 90, 90)

-- Toggles visibility of the menu instead of permanently hiding it
HamburgerBtn.MouseButton1Click:Connect(function()
    MainFrame.Visible = not MainFrame.Visible 
end)

-- Button Creation Helper (Makes the code much cleaner)
local function CreateToggleButton(yPos, textOff, textOn, toggleVar)
    local Btn = Instance.new('TextButton', MainFrame)
    Btn.Size = UDim2.fromOffset(180, 27)
    Btn.Position = UDim2.fromOffset(20, yPos)
    Btn.BackgroundColor3 = Color3.fromRGB(60, 60, 60)
    Btn.TextColor3 = Color3.new(1, 1, 1)
    Btn.Font = Enum.Font.GothamBold
    Btn.TextSize = 11
    Btn.Text = textOff
    
    local Corner = Instance.new('UICorner', Btn)
    Corner.CornerRadius = UDim.new(0, 10)
    
    Btn.MouseButton1Click:Connect(function()
        genv[toggleVar] = not genv[toggleVar] -- Toggles true/false correctly
        if genv[toggleVar] then
            Btn.Text = textOn
        else
            Btn.Text = textOff
        end
    end)
end

-- Create all buttons
CreateToggleButton(30, 'Brainrots MYTHICAL : OFF', 'AUTO MYTHICAL : ON', 'AUTO_MYTHICAL')
CreateToggleButton(60, 'Brainrots SECRET : OFF', 'AUTO SECRET : ON', 'AUTO_SECRET')
CreateToggleButton(90, 'AUTO MONEY : OFF', 'COLLECT MONEY : ON', 'AUTO_MONEY')
CreateToggleButton(120, 'SPEED +1 : OFF', 'SPEED +1 : ON', 'AUTO_SPEED_1')
CreateToggleButton(150, 'SPEED +10 : OFF', 'SPEED +10 : ON', 'AUTO_SPEED_10')
CreateToggleButton(180, 'AUTO REBIRTH : OFF', 'AUTO REBIRTH : ON', 'AUTO_REBIRTH')
CreateToggleButton(210, 'REMOVE WAVE : OFF', 'REMOVE WAVE : ON', 'AUTO_REMOVE_WAVE')
